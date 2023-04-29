(ns me.pmatiello.tui.core-test
  (:require [clojure.test :refer :all]
            [me.pmatiello.tui.core :as tui]
            [me.pmatiello.tui.fixtures :as fixtures]))

(use-fixtures :each fixtures/with-readable-csi)

(deftest +style-test
  (testing "adds styling data to body"
    (is (= "\\u001b[1m\\u001b[34m!text!\\u001b[0m"
           (tui/+style "!text!" :style [:bold :fg-blue]))))

  (testing "optionally resets to a custom style"
    (is (= "\\u001b[1m\\u001b[34m!text!\\u001b[39m"
           (tui/+style "!text!" :style [:bold :fg-blue] :reset [:fg-default]))))

  (testing "validates that given styles are valid"
    (is (thrown? AssertionError (tui/+style "text" :style [:invalid])))
    (is (thrown? AssertionError (tui/+style "text" :reset [:invalid])))))
