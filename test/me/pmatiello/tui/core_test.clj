(ns me.pmatiello.tui.core-test
  (:require [clojure.test :refer :all]
            [me.pmatiello.tui.core :as tui]
            [me.pmatiello.tui.fixtures :as fixtures]))

(use-fixtures :each fixtures/with-readable-csi)

(deftest render-test
  (testing "renders plain text"
    (is (= "plain text"
           (tui/render ["plain text"]))))

  (testing "concatenates multiple text fragments"
    (is (= "plain text"
           (tui/render ["plain" " " "text"]))))

  (testing "renders styled text"
    (is (= "\\u001b[1m\\u001b[34m!styled!\\u001b[0mtext"
           (tui/render [{:style [:bold :fg-blue] :body "!styled!"} "text"]))))

  (testing "validates that given styles are valid"
    (is (thrown? AssertionError (tui/render [[[:invalid] "invalid"]]))))

  (testing "renders multiple text fragments, with a custom separator"
    (is (= "plain text"
           (tui/render ["plain" "text"] {:separator " "}))))

  (testing "renders multiple text fragments, with a custom separator, with style"
    (is (= "plain\\u001b[1m-\\u001b[0mtext"
           (tui/render ["plain" "text"] {:separator {:style [:bold] :body "-"}})))))
