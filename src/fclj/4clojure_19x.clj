(ns fclj.4clojure-19x)

(defn n195
  "Parentheses...Again"
  ([n] (if (zero? n) #{""} (set (n195 n 0))))
  ([n open]
   (if (zero? n)
     (vector (apply str (repeat open ")")))
     (if (zero? open)
       (map #(str "(" %) (n195 (dec n) 1))
       (concat
        (map #(str ")" %) (n195 n (dec open)))
        (map #(str "(" %) (n195 (dec n) (inc open))))))))
