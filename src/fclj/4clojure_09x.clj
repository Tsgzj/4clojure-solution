(ns fclj.4clojure-09x)

(defn n90
  "Cartesion Product"
  [a b]
  (set
   (for [x a
         y b]
     [x y])))
