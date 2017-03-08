(ns fclj.4clojure-08x)

(defn n83
  "Half truth"
  [& args]
  (not (apply = args)))
