(defproject api-quiz "0.1.0-SNAPSHOT"
  :description "Simpe API server"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/data.json "0.2.0"]
                 [compojure "1.1.3"]
                 [ring/ring-core "1.1.6"]
                 [ring/ring-jetty-adapter "1.1.6"]]
  :main api-quiz.core)