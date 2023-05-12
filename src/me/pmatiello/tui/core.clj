(ns me.pmatiello.tui.core
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as string]
            [me.pmatiello.tui.internal.specs :as specs]
            [me.pmatiello.tui.internal.rendering :as rendering])
  (:refer-clojure :exclude [print println read-line])
  (:import (java.io BufferedReader)))

(defn render
  ([page]
   (render page {:separator ""}))
  ([page {:keys [separator]}]
   (assert (s/valid? ::specs/page page))
   (assert (s/valid? ::specs/text separator))
   (let [separator-str (rendering/render separator)]
     (->> (map rendering/render page)
          (string/join separator-str)))))

(s/fdef render
  :args (s/cat :page ::specs/page
               :opts (s/? ::specs/render-opts))
  :ret ::specs/string)

(defn print
  [& page]
  (-> page
      (render {:separator " "})
      clojure.core/print))

(s/fdef print
  :args (s/cat :page (s/* ::specs/text))
  :ret ::specs/string)

(defn println
  [& page]
  (-> page
      (render {:separator " "})
      clojure.core/println))

(s/fdef println
  :args (s/cat :page (s/* ::specs/text))
  :ret ::specs/string)

(defn read-line
  []
  (clojure.core/read-line))

(s/fdef read-line
  :ret ::specs/string)

(defn read-lines []
  (let [buffered-reader (BufferedReader. *in*)]
    (doall (line-seq buffered-reader))))

(s/fdef read-lines
  :ret (s/coll-of ::specs/string))
