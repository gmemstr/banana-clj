; I'm not entirely sure what I'm doing with my life at this point in time.
(ns banana-clj.core
	(:require [clojure.string :as string]
		[clojure.pprint :as pprint]))

; Binary translation stuff from
; https://gist.github.com/emdeesee/3827341
(defn to-binary [string] 
	(string/replace (string/trim (
			pprint/cl-format nil "~{~8,'0b ~}" (map #(int %) string))) " " ""))

(defn from-binary [binary]
  (->> (partition 8 binary)
       (map #(char (Integer/parseInt (apply str %) 2)))
       (apply str)
       (string/trim))
)

(defn grow-banana [seed]
	"Grow a banana!"
	(str "b" (string/replace (string/replace (to-binary seed) "0" "a") "1" "n"))
)

(defn peel-banana [banana] 
	"Peel a banana!"
	(from-binary (string/replace (string/replace (string/replace banana "a" "0") "n" "1") "b" ""))
)
