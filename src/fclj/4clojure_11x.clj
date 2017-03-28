(ns fclj.4clojure-11x)

(defn n118
  "Re-implement Map"
  [f s]
  (reduce (fn [lst e]
                (cons (f e) lst))
              []
              (reverse s))))
