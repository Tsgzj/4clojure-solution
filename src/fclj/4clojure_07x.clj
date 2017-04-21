(ns fclj.4clojure-07x)

(defn n70
  "Word sorting"
  [s]
  (sort-by #(clojure.string/lower-case %)
           (clojure.string/split (clojure.string/replace s
                                                         #"[.!]"
                                                         "")
                                 #" ")))
