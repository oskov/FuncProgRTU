(def data {"Inese" 10 "Vasja" 8 "Petja" 4 "Natasha" 7
"Anja" 10 "Lauris" 6 "Sandra" 8 "Krišjanis" 9})
(def sorted (select-keys data (for [[k v] data :when (= (subs k (- (.length k) 1)) "a")] k)))
(str "Simple solution")
(/ (double (reduce + (vals sorted))) (count sorted))
(str "Extra solution")
(defn avg [coll] (apply / (reduce (fn [[sum n] x] [(+ sum x) (inc n)]) [0.0 0.0] coll)))
(avg (vals sorted))