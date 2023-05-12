(ns
  ^{:doc "Functions for terminal user interfaces."}
  me.pmatiello.tui.core
  (:refer-clojure :exclude [print println read-line])
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as string]
            [me.pmatiello.tui.internal.rendering :as rendering]
            [me.pmatiello.tui.internal.specs :as specs])
  (:import (java.io BufferedReader)))

(defn render
  "Renders a page (as a string).

  Arguments:
  - page [me.pmatiello.tui.internal.specs/page]
  - opts [:me.pmatiello.tui.internal.specs/render-opts, optional]

  Examples:
  - (render [\"plain text\"])
  - (render [\"plain\", \" \", \"text\"])
  - (render [{:style [:bold :fg-blue] :body \"!styled!\"} \"text\"])
  - (render [\"plain\", \"text\"] {:separator \" \"})
  - (render [\"plain\", \"text\"] {:separator {:style [:bold] :body \"-\"}})"
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
  "Prints a page to stdout.

  Arguments:
  - page [me.pmatiello.tui.internal.specs/page, variadic]

  Examples:
  - (print \"plain text\")
  - (print \"plain\" \"text\")
  - (print {:style [:bold :fg-blue] :body \"!styled!\"} \"text\")"
  [& page]
  (-> page
      (render {:separator " "})
      clojure.core/print))

(s/fdef print
  :args (s/cat :page (s/* ::specs/text))
  :ret ::specs/string)

(defn println
  "Prints a page to stdout. Add a new line at the end.

  Arguments:
  - page [me.pmatiello.tui.internal.specs/page, variadic]

  Examples:
  - (println \"plain text\")
  - (println \"plain\" \"text\")
  - (println {:style [:bold :fg-blue] :body \"!styled!\"} \"text\")"
  [& page]
  (-> page
      (render {:separator " "})
      clojure.core/println))

(s/fdef println
  :args (s/cat :page (s/* ::specs/text))
  :ret ::specs/string)

(defn read-line
  "Reads a single line from *in*."
  []
  (clojure.core/read-line))

(s/fdef read-line
  :ret ::specs/string)

(defn read-lines
  "Reads lines from *in* until EOF."
  []
  (let [buffered-reader (BufferedReader. *in*)]
    (doall (line-seq buffered-reader))))

(s/fdef read-lines
  :ret (s/coll-of ::specs/string))
