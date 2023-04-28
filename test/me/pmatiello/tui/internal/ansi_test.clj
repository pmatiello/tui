(ns me.pmatiello.tui.internal.ansi-test
  (:require [clojure.test :refer :all]
            [me.pmatiello.tui.internal.ansi :as ansi]
            [me.pmatiello.tui.fixtures :as fixtures]))

(use-fixtures :each fixtures/with-readable-csi)

(deftest reset-test
  (is (= "\\u001b[0m" (ansi/reset))))

(deftest bold-test
  (is (= "\\u001b[1m" (ansi/bold))))

(deftest faint-test
  (is (= "\\u001b[2m" (ansi/faint))))

(deftest italic-test
  (is (= "\\u001b[3m" (ansi/italic))))

(deftest underline-test
  (is (= "\\u001b[4m" (ansi/underline))))

(deftest slow-blink-test
  (is (= "\\u001b[5m" (ansi/slow-blink))))

(deftest fast-blink-test
  (is (= "\\u001b[6m" (ansi/fast-blink))))

(deftest reverse-video-test
  (is (= "\\u001b[7m") (ansi/reverse-video)))

(deftest conceal-test
  (is (= "\\u001b[8m") (ansi/conceal)))

(deftest strike-test
  (is (= "\\u001b[9m") (ansi/strike)))

(deftest weight-off-test
  (is (= "\\u001b[22") (ansi/weight-off)))

(deftest italic-off-test
  (is (= "\\u001b[23") (ansi/italic-off)))

(deftest underline-off-test
  (is (= "\\u001b[24") (ansi/underline-off)))

(deftest blink-off-test
  (is (= "\\u001b[25") (ansi/blink-off)))

(deftest reverse-video-off-test
  (is (= "\\u001b[27") (ansi/reverse-video-off)))

(deftest conceal-off-test
  (is (= "\\u001b[28") (ansi/conceal-off)))

(deftest strike-off-test
  (is (= "\\u001b[29") (ansi/strike-off)))

(deftest fg-black-test
  (is (= "\\u001b[30m") (ansi/fg-black)))

(deftest fg-red-test
  (is (= "\\u001b[31m") (ansi/fg-red)))

(deftest fg-green-test
  (is (= "\\u001b[32m") (ansi/fg-green)))

(deftest fg-yellow-test
  (is (= "\\u001b[33m") (ansi/fg-yellow)))

(deftest fg-blue-test
  (is (= "\\u001b[34m") (ansi/fg-blue)))

(deftest fg-purple-test
  (is (= "\\u001b[35m") (ansi/fg-purple)))

(deftest fg-cyan-test
  (is (= "\\u001b[36m") (ansi/fg-cyan)))

(deftest fg-white-test
  (is (= "\\u001b[37m") (ansi/fg-white)))

(deftest fg-default-test
  (is (= "\\u001b[39m") (ansi/fg-default)))

(deftest bg-black-test
  (is (= "\\u001b[40m") (ansi/bg-black)))

(deftest bg-red-test
  (is (= "\\u001b[41m") (ansi/bg-red)))

(deftest bg-green-test
  (is (= "\\u001b[42m") (ansi/bg-green)))

(deftest bg-yellow-test
  (is (= "\\u001b[43m") (ansi/bg-yellow)))

(deftest bg-blue-test
  (is (= "\\u001b[44m") (ansi/bg-blue)))

(deftest bg-purple-test
  (is (= "\\u001b[45m") (ansi/bg-purple)))

(deftest bg-cyan-test
  (is (= "\\u001b[46m") (ansi/bg-cyan)))

(deftest bg-white-test
  (is (= "\\u001b[47m") (ansi/bg-white)))

(deftest bg-default-test
  (is (= "\\u001b[49m") (ansi/bg-default)))

