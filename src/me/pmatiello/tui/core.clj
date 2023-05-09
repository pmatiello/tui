(ns me.pmatiello.tui.core
  (:require [clojure.spec.alpha :as s]
            [me.pmatiello.tui.internal.specs :as specs]
            [me.pmatiello.tui.internal.rendering :as rendering]))

(defn render
  [& text]
  (assert (s/valid? (s/* ::specs/text) text))
  (->> text
       (map rendering/render)
       (apply str)))

(s/fdef render
  :args (s/cat :text (s/* ::specs/text))
  :ret ::specs/string)
