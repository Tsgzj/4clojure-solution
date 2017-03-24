(ns fclj.4clojure-09x)

(defn n90
  "Cartesion Product"
  [a b]
  (set
   (for [x a
         y b]
     [x y])))

(defn n95
  "To tree or not to tree"
  [root]
  (or (nil? root)
      (and (sequential? root)
           (= 3 (count root))
           (and (n95 (second root))
                (n95 (last root))))))

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
