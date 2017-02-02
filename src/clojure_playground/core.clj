(ns clojure-playground.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn factorial
  ([x] (factorial 1 x))
  ([acc x]
   (if (zero? x)
     acc
     (recur (*' x acc) (dec x)))))

(defn factorial-reduce
  "Seems the reduce version is fater, thanks to lazyness of range(?)"
  [x]
  (reduce *' (range 1 (inc x))))

(defn bfs
  [& tree]
  (if (seq tree)
    (concat (map first tree)
            (apply bfs (mapcat rest tree)))))
