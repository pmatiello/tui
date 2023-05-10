(ns me.pmatiello.tui.core
  (:require [clojure.spec.alpha :as s]
            [me.pmatiello.tui.internal.specs :as specs]
            [me.pmatiello.tui.internal.rendering :as rendering]))

(defn render
  [page]
  (assert (s/valid? ::specs/page page))
  (->> page
       (map rendering/render)
       (apply str)))

(s/fdef render
  :args (s/cat :page ::specs/page)
  :ret ::specs/string)
