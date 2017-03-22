(ns fclj.n135
  (:requeri [clojure.test :refer :all]))

(defn __
  [val & args]
  (reduce
   (fn
     [a [f b]]
     (f a b))
   val
   (partition 2 args)))

(deftest n135-test
  (testing "n135"
    (is (= 7  (__ 2 + 5)))
    (is (= 42 (__ 38 + 48 - 2 / 2)))
    (is (= 8  (__ 10 / 2 - 1 * 2)))
    (is (= 72 (__ 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)))))
