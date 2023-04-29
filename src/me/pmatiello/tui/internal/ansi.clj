(ns me.pmatiello.tui.internal.ansi)

(def ^:private csi "\u001b[")

(defn ^:private ansi-seq [& code]
  (apply str csi code))

(defn reset []
  (ansi-seq "0m"))

(defn bold []
  (ansi-seq "1m"))

(defn faint []
  (ansi-seq "2m"))

(defn italic []
  (ansi-seq "3m"))

(defn underline []
  (ansi-seq "4m"))

(defn slow-blink []
  (ansi-seq "5m"))

(defn fast-blink []
  (ansi-seq "6m"))

(defn reverse-video []
  (ansi-seq "7m"))

(defn conceal []
  (ansi-seq "8m"))

(defn strike []
  (ansi-seq "9m"))

(defn weight-off []
  (ansi-seq "22m"))

(defn italic-off []
  (ansi-seq "23m"))

(defn underline-off []
  (ansi-seq "24m"))

(defn blink-off []
  (ansi-seq "25m"))

(defn reverse-video-off []
  (ansi-seq "27m"))

(defn conceal-off []
  (ansi-seq "28m"))

(defn strike-off []
  (ansi-seq "29m"))

(defn fg-black []
  (ansi-seq "30m"))

(defn fg-red []
  (ansi-seq "31m"))

(defn fg-green []
  (ansi-seq "32m"))

(defn fg-yellow []
  (ansi-seq "33m"))

(defn fg-blue []
  (ansi-seq "34m"))

(defn fg-purple []
  (ansi-seq "35m"))

(defn fg-cyan []
  (ansi-seq "36m"))

(defn fg-white []
  (ansi-seq "37m"))

(defn fg-default []
  (ansi-seq "39m"))

(defn bg-black []
  (ansi-seq "40m"))

(defn bg-red []
  (ansi-seq "41m"))

(defn bg-green []
  (ansi-seq "42m"))

(defn bg-yellow []
  (ansi-seq "43m"))

(defn bg-blue []
  (ansi-seq "44m"))

(defn bg-purple []
  (ansi-seq "45m"))

(defn bg-cyan []
  (ansi-seq "46m"))

(defn bg-white []
  (ansi-seq "47m"))

(defn bg-default []
  (ansi-seq "49m"))
