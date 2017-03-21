(ns fclj.4clojure-13x)

(defn n135
  [op1 f op2 & re]
  (if (= (count (flatten re)) 0)
    (f op1 op2)
    (n135 (f op1 op2) (first re) (second re) (drop 2 re))))
