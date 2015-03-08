(ns jubot.catalog.{{name}}-test
  (:require
    [clojure.test :refer :all]
    [jubot.catalog.{{name}} :refer :all]))

(deftest test-{{name}}-handler
  (is (= "bar" ({{name}}-handler {:text "foo"}))))
