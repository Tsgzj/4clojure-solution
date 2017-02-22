(ns fclj.4clojure_04x)

(defn n42
  "https://www.4clojure.com/problem/42 factorial"
  [x]
  (letfn [(f-helper
            [x res]
            (if (= x 1)
              res
              (f-helper (dec x) (* res x))))]
    (f-helper x 1)))

(defn n42-low-golf
  [x]
  (reduce * (range 1 (inc x))))
