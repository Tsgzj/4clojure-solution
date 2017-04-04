(ns fclj.4clojure-12x)

(defn n120
  "Sum of square of digits"
  [coll]
  (count (filter (fn [x]
                   (let [digs (map #(- (int %) 48) (str x))]
                     (< x (reduce + (map #(* % %) digs)))))
                 coll)))

(defn n122
  "binary number
  using java integer"
  [x]
  (Integer/parseInt x 2))
