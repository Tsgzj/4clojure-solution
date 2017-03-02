(ns fclj.4clojure_05x)

(defn n50
  "Split by type"
  [lst]
  (vals (group-by class lst)))
