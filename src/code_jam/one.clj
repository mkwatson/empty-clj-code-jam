(ns code-jam.one
  (:require [clojure.java.io :refer [reader writer]]))

(def process-line nil)

(defn process-file
  [filename]
  (with-open [rdr (reader filename)
              wrtr (writer "out.txt")]
    (let [i (atom 1)]
      (doseq [line (rest (line-seq rdr))]
        (.write wrtr (str "Case #" @i ": "))
        (swap! i inc)
        (.write wrtr (process-line line))))))
