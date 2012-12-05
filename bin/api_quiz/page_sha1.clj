(ns api-quiz.page-sha1
  (:import (java.security MessageDigest)
           (java.net URL)
           (java.lang StringBuilder)
           (java.io BufferedReader InputStreamReader)))

(defn fetch-url
  "Return the web page as a string."
  [address]
  (let [url (URL. address)]
    (with-open [stream (. url (openStream))]
      (let [buf (BufferedReader. (InputStreamReader. stream))]
        (apply str (line-seq buf))))))

 
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


