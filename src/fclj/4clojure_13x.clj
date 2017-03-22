(ns fclj.4clojure-13x)

(defn __
  [val & args]
  (reduce
   (fn
     [a [f b]]
     (f a b))
   val
   (partition 2 args)))
