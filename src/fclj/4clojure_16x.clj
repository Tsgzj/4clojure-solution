(ns fclj.4clojure-16x)

(defn n166
  "Comparisons"
  [op a b]
  (cond
    (op a b) :lt
    (op b a) :gt
    :else :eq))

(defn n168
  "Infinate Matrix"
  ([f] (n168 f 0 0))
  ([f i j] (letfn
               [(in [a b]
                  (lazy-seq (cons (f a b) (in a (inc b)))))
                (out [a b]
                  (lazy-seq (cons (in a b) (out (inc a) b))))]
             (out i j)))
  ([f i j x y] (take x (map #(take y %) (n168 f i j)))))
