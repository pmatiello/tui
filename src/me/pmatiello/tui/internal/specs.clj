(ns ^:no-doc me.pmatiello.tui.internal.specs
  (:require [clojure.spec.alpha :as s]))

(def ^:private style*?
  #{:reset :bold :faint :italic :underline :slow-blink :fast-blink :reverse-video
    :conceal :strike :weight-off :italic-off :underline-off :blink-off
    :reverse-video-off :conceal-off :strike-off :fg-black :fg-red :fg-green :fg-yellow
    :fg-blue :fg-purple :fg-cyan :fg-white :fg-default :bg-black :bg-red :bg-green
    :bg-yellow :bg-blue :bg-purple :bg-cyan :bg-white :bg-default})

(s/def ::body
  (s/or :char char? :string string?))
(s/def ::string string?)
(s/def ::style* style*?)

(s/def ::style
  (s/coll-of ::style*))

(s/def ::body+style
  (s/keys :req-un [::body ::style]))

(s/def ::text
  (s/or :body ::body
        :body+style ::body+style))

(s/def ::page
  (-> (s/coll-of ::text) (s/nilable)))

(s/def ::separator ::text)

(s/def ::render-opts
  (s/keys :opt-un [::separator]))
