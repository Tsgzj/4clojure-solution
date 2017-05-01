(ns fclj.4clojure-07x)

(defn n70
  "Word sorting"
  [s]
  (sort-by #(clojure.string/lower-case %)
           (clojure.string/split (clojure.string/replace s
                                                         #"[.!]"
                                                         "")
                                 #" ")))

(defn n77
  "Anagram Finder"
  [l]
  (set
   (map set
        (filter #(> (count %) 1)
                (vals (group-by sort l))))))
