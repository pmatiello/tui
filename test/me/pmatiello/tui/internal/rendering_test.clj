(ns me.pmatiello.tui.internal.rendering-test
  (:require [clojure.test :refer :all]
            [me.pmatiello.tui.fixtures :as fixtures]
            [me.pmatiello.tui.internal.rendering :as rendering]))

(use-fixtures :each fixtures/with-readable-csi)

(deftest render-test
  (testing "renders plain text"
    (is (= "plain text" (rendering/render "plain text"))))

  (testing "renders styled text"
    (is (= "\\u001b[1m\\u001b[34m!styled!\\u001b[0m"
           (rendering/render [[:bold :fg-blue] "!styled!"])))))
