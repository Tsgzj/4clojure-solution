(ns fclj.4clojure)

(defn n21
  "https://www.4clojure.com/problem/21 nth element"
  [lst n]
  (if (= n 0)
    (first lst)
    (recur (rest lst) (dec n))))

(defn n22
  "https://www.4clojure.com/problem/22#prob-title Count a sequence"
  [x]
  (letfn [(count-sequence-helper [x n]
            (if (empty? x)
              n
              (count-sequence-helper (rest x) (inc n))))]
    (count-sequence-helper x 0)))

(defn n23
  "https://www.4clojure.com/problem/23#prob-title Reverse sequence"
  [list]
  ;; notice that (conj [1 2 3] 1) return [1 2 3 1]
  ;; while (conj (1 2 3) 1) return (1 1 2 3)
  ;; it always adds the item to the most `efficient` place
  ;; this will return the sequence of same order
  ;; (reducet conj [] list)
  (reduce conj () list))

(defn n24
  "https://www.4clojure.com/problem/24#prob-title Sum it up"
  [list]
  ;; basic reduce
  (reduce + list))

(defn n25
  "https://www.4clojure.com/problem/25#prob-title Odd numbers"
  [list]
  (filter odd? list))

(defn n26
  "https://www.4clojure.com/problem/26#prob-title Fibosacci Sequence"
  ;; not an optimal implementation
  ;; but it `works`
  [x]
  (if (= x 1)
    [1]
    (if (= x 2)
      [1 1]
      (let
       [prev-list (n26 (dec x))]
        (conj
         prev-list
         (+ (last prev-list)
            (last (butlast prev-list))))))))

(defn fib
  [x]
  (letfn [(fib-helper
            [x prev cur]
            (if (= x 0)
              cur
              (fib-helper (dec x) cur (+ prev cur))))]
    (fib-helper (dec x) 0 1)))
;; a better version of fibonacci
;; but not sequence

(defn n27
  "https://www.4clojure.com/problem/27#prob-title Palindrome Detector"
  [x]
  (= (seq x) (reverse x)))
;; seq "racecar" retuerns '(\r \a \c \e \c \a \r)

(defn n28
  "https://www.4clojure.com/problem/28 Flatten sequence"
  [x]
  (if (coll? x)
    ;;(apply concat (map n28 x)) equals to
    (mapcat n28 x)
    (list x)))

(defn n29
  "https://www.4clojure.com/problem/29 Get the Caps"
  [x]
  (apply str (filter (set (map char (range 65 91))) x)))
