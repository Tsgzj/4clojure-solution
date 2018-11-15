(ns fclj.spec-test
  (:require [clojure.spec.alpha :as s]
            [orchestra.spec.test :as st]))

(defn adder
  [x]
  #(+ x %))

(s/fdef adder
  :args (s/cat :x number?)
  :ret (s/fspec :args (s/cat :y number?)
                :ret number?))

(st/instrument `adder)

((adder 10) 10)
