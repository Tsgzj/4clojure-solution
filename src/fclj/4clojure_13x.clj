(ns fclj.4clojure-13x)

(defn n135
  [val & args]
  (reduce
   (fn
     [a [f b]]
     (f a b))
   val
   (partition 2 args)))
