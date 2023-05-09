(ns me.pmatiello.tui.internal.specs
  (:require [clojure.spec.alpha :as s]))

(def style*?
  #{:reset :bold :faint :italic :underline :slow-blink :fast-blink :reverse-video
    :conceal :strike :weight-off :italic-off :underline-off :blink-off
    :reverse-video-off :conceal-off :strike-off :fg-black :fg-red :fg-green :fg-yellow
    :fg-blue :fg-purple :fg-cyan :fg-white :fg-default :bg-black :bg-red :bg-green
    :bg-yellow :bg-blue :bg-purple :bg-cyan :bg-white :bg-default})

(s/def ::style* style*?)

(s/def ::style (s/coll-of ::style*))

(s/def ::string string?)

(s/def ::style+string
  (s/tuple ::style ::string))

(s/def ::text
  (s/or :string ::string
        :style+string ::style+string))
