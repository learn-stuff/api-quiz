(ns api-quiz.sha1
  (:import (java.security MessageDigest)))
 
(defn get-hash [type data]
  (.digest (MessageDigest/getInstance type) (.getBytes data) ))

(defn sha1-hash [data]
  (get-hash "sha1" data))

(defn get-hash-str [data-bytes]
  (apply str 
    (map 
      #(.substring 
         (Integer/toString 
           (+ (bit-and % 0xff) 0x100) 16) 1) 
      data-bytes)))

(defn sha1 [data]
  (get-hash-str (sha1-hash data)))


