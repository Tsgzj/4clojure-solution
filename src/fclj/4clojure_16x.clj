(ns fclj.4clojure-16x)

(defn n166
  "Comparisons"
  [op a b]
  (cond
    (op a b) :lt
    (op b a) :gt
    :else :eq))
