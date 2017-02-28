(ns fclj.4clojure_04x)

(defn n41
  "https://www.4clojure.com/problem/41 drop every nth"
  [lst n]
  (if (< (count lst) n)
    lst
    (concat (take (dec n) lst) (n41 (drop n lst) n))))

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

(defn n43
  [lst n]
  (apply map vector (partition n lst)))

(defn n44
  "Rotate Sequence"
  [n lst]
  (take (count lst) (drop (mod n (count lst)) (cycle lst))))

(defn n49
  "https://www.4clojure.com/problem/49#prob-title split-at"
  [n lst]
  (vector (take n lst) (drop n lst)))
