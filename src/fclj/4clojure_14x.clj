(ns fclj.4clojure-14x)

(defn n143
  "dot product"
  [a b]
  (apply + (map * a b)))

(defn n147
  "Pascal's Trapezoid"
  [p]
  (iterate #(vec (map +' (cons 0 %) (conj % 0))) p))

(defn n148
  [j k l]
  (letfn [(sum [a n]
            (/ (* n (+ a (* n a))) 2))
          (tit [x y]
            (sum x (bigint (quot (dec y) x))))]
    (- (+ (tit k j)
          (tit l j))
       (tit (* k l) j))))
