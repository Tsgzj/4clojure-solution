(ns fclj.4clojure-14x)

(defn n143
  "dot product"
  [a b]
  (apply + (map * a b)))

(defn n147
  "Pascal's Trapezoid"
  [p]
  (iterate #(vec (map +' (cons 0 %) (conj % 0))) p))
