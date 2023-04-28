(ns me.pmatiello.tui.fixtures
  (:require [me.pmatiello.tui.internal.ansi :as ansi]))

(defn with-readable-csi [f]
  (with-redefs
    [ansi/csi "\\u001b["]
    (f)))
