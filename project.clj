(defproject solr-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :java-source-paths ["src/java"]
  :source-paths ["src/clojure"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.slf4j/slf4j-api "1.7.25"]
                 [org.slf4j/slf4j-log4j12 "1.7.25"]
                 [org.apache.solr/solr-core "5.5.1"]
                 [org.apache.solr/solr-solrj "5.5.1"]])
