(ns fclj.4clojure-11x)

(defn n118-not-working
  "Re-implement Map"
  [f s]
   (reduce (fn [lst e]
             (cons (f e) lst))
           []
           (reverse s)))

(defn n118
  "Re-umplement Map"
  [f s]
  (if (not (empty? s))
    (lazy-seq
     (cons (f (first s))
           (n118 f (rest s))))))
