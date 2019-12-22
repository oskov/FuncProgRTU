(require '[clojure.string :as string])

(defn createVector [rows]
      (vec (replicate rows [])))

(defn abs [x]
      (if (> x 0) x (* -1 x)))

(defn calculateRow [rows idx]
      (- (- rows 1) (abs (- (- rows 1) (mod idx (* 2 (- rows 1)))))))

(defn removeSpaces [str]
      (clojure.string/replace str #" " "_"))

; returns vector of tuples [row letter]
(defn getTuples [str secret-key]
      (map-indexed (fn [idx itm] [(calculateRow secret-key idx) itm idx]) str))

(defn encrypt [str secret-key]
      (let [vec (createVector secret-key)]
           (string/join
             (map string/join
                  (reduce (fn [carry item]
                              (let [idx (get item 0) char (get item 1)]
                                   (assoc carry idx (conj (get carry idx) char))))
                          (createVector 3)
                          (getTuples (removeSpaces str) secret-key))))))

(defn decrypt [str secret-key]
      (let [vec (createVector secret-key)]
           (string/join
             (map-indexed (fn [idx itm]
                              (.charAt str
                                       (.indexOf (flatten
                                                   (reduce (fn [carry item]
                                                               (let [idx (get item 0) char (get item 1)]
                                                                    (assoc carry idx (conj (get carry idx) (get item 2)))))
                                                           (createVector 3)
                                                           (getTuples (removeSpaces str) secret-key)))
                                                 idx)))
                          str))))

; Testing  

;case 1
(println "case 1")

(def testCase "WEAREDISCOVEREDFLEEATONCE")
(def level 3)
(def encrypted (encrypt testCase level))
(def decrypted (decrypt encrypted level))

(println encrypted)
(println decrypted)
(println "")

(assert (= decrypted testCase))

;case 2
(println "case 1")

(def testCase "WE ARE DISCOVERED. FLEE AT ONCE")
(def expected "WE_ARE_DISCOVERED._FLEE_AT_ONCE")
(def level 3)
(def encrypted (encrypt testCase level))
(def decrypted (decrypt encrypted level))

(println encrypted)
(println decrypted)
(println "")

(assert (= decrypted expected))

;case 3
(println "case 3")

(def testCase "WE ARE DISCOVERED. FLEE AT ONCE")
(def expected "WE_ARE_DISCOVERED._FLEE_AT_ONCE")
(def level 4)
(def encrypted (encrypt testCase level))
(def decrypted (decrypt encrypted level))

(println encrypted)
(println decrypted)
(println "")

(assert (= decrypted expected))

;case 4
(println "case 4")

(def testCase "WE ARE DISCOVERED. FLEE AT ONCE")
(def expected "WE_ARE_DISCOVERED._FLEE_AT_ONCE")
(def level 2)
(def encrypted (encrypt testCase level))
(def decrypted (decrypt encrypted level))

(println encrypted)
(println decrypted)
(println "")

(assert (= decrypted expected))