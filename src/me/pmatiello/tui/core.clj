(ns me.pmatiello.tui.core
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as string]
            [me.pmatiello.tui.internal.specs :as specs]
            [me.pmatiello.tui.internal.rendering :as rendering]))

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
