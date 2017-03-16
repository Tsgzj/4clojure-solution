(ns fclj.4clojure-09x)

(defn n90
  "Cartesion Product"
  [a b]
  (set
   (for [x a
         y b]
     [x y])))

(defn n99
  "Product Digits"
  [a b]
  (let [res (* a b)]
    (letfn [(pd [x]
              (if (< x 10)
                [x]
                (cons (mod x 10) (pd (quot x 10)))))]
      (reverse (pd res)))))

(defn n99-low-golf
  [a b]
  (->> (* a b)
       str
       seq
       (map str)
       (map read-string)))
