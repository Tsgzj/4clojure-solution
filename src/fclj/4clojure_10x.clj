(ns fclj.4clojure-10x)

(defn n107
  [a]
  (letfn
      [(power [n x]
         (apply * (repeat n x)))]
    (partial power a)))
