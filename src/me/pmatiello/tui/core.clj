(ns me.pmatiello.tui.core
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as string]
            [me.pmatiello.tui.internal.ansi :as ansi]
            [me.pmatiello.tui.internal.specs :as specs]))

(def ^:private style->str*
  {:reset         ansi/reset
   :bold          ansi/bold
   :bold-off      ansi/weight-off
   :underline     ansi/underline
   :underline-off ansi/underline-off
   :blink         ansi/slow-blink
   :blink-off     ansi/blink-off
   :fg-black      ansi/fg-black
   :fg-red        ansi/fg-red
   :fg-green      ansi/fg-green
   :fg-yellow     ansi/fg-yellow
   :fg-blue       ansi/fg-blue
   :fg-purple     ansi/fg-purple
   :fg-cyan       ansi/fg-cyan
   :fg-white      ansi/fg-white
   :fg-default    ansi/fg-default
   :bg-black      ansi/bg-black
   :bg-red        ansi/bg-red
   :bg-green      ansi/bg-green
   :bg-yellow     ansi/bg-yellow
   :bg-blue       ansi/bg-blue
   :bg-purple     ansi/bg-purple
   :bg-cyan       ansi/bg-cyan
   :bg-white      ansi/bg-white
   :bg-default    ansi/bg-default})

(defn ^:private style->str
  [style]
  (->> style
       (map style->str*)
       (map #(apply % nil))
       string/join))

(defn +style
  [text & {:keys [style reset]}]
  (let [style (or style [])
        reset (or reset [:reset])]
    (assert (s/valid? ::specs/style style))
    (assert (s/valid? ::specs/reset reset))
    (str (style->str style) text (style->str reset))))

(s/fdef +style
  :args (s/cat :text ::specs/text
               :args (s/keys* :opt-un [::specs/style ::specs/reset]))
  :ret ::specs/text)
