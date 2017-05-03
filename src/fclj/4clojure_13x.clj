(ns fclj.4clojure-13x)

(defn n135
  [val & args]
  (reduce
   (fn
     [a [f b]]
     (f a b))
   val
   (partition 2 args)))

(defn n137
  "Digits and bases"
  [n b]
  (if (< n b)
    [(rem n b)]
    (conj (n137 (quot n b) b) (rem n b))))
