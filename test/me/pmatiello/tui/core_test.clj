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
    (is (thrown? AssertionError (tui/render [{:style [:invalid] :body "invalid"}]))))

  (testing "renders multiple text fragments, with a custom separator"
    (is (= "plain text"
           (tui/render ["plain" "text"] {:separator " "}))))

  (testing "renders multiple text fragments, with a custom separator, with style"
    (is (= "plain\\u001b[1m-\\u001b[0mtext"
           (tui/render ["plain" "text"] {:separator {:style [:bold] :body "-"}})))))

(deftest print-test
  (testing "prints plain text"
    (is (= "plain text"
           (with-out-str (tui/print "plain text")))))

  (testing "prints multiple text fragments separated by space"
    (is (= "plain text"
           (with-out-str (tui/print "plain" "text")))))

  (testing "prints styled text"
    (is (= "\\u001b[1m\\u001b[34m!styled!\\u001b[0m text"
           (with-out-str
             (tui/print {:style [:bold :fg-blue] :body "!styled!"} "text"))))))

(deftest println-test
  (testing "prints plain text, followed by newline"
    (is (= "plain text\n"
           (with-out-str (tui/println "plain text")))))

  (testing "prints multiple text fragments separated by space"
    (is (= "plain text\n"
           (with-out-str (tui/println "plain" "text")))))

  (testing "prints styled text"
    (is (= "\\u001b[1m\\u001b[34m!styled!\\u001b[0m text\n"
           (with-out-str
             (tui/println {:style [:bold :fg-blue] :body "!styled!"} "text"))))))

(deftest read-line-test
  (testing "reads line from stdin"
    (is (= "read line"
           (with-in-str "read line"
             (tui/read-line)))))

  (testing "only reads a single line"
    (is (= "first line"
           (with-in-str "first line\nsecond line"
             (tui/read-line))))))

(deftest read-lines-test
  (testing "reads lines from stdin until eof"
    (is (= ["first line" "second line"]
           (with-in-str "first line\nsecond line\n"
             (tui/read-lines))))))
