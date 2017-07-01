mv src/java/org/apache src/java/org/clojurians
find src/java/org/clojurians -name "*.java" | xargs -I {} sed -i '.bk' 's/org.apache.solr.common/org.clojurians.solr.common/' {}
find src/java/org/clojurians -name "*.java" | xargs -I {} sed -i '.bk' 's/org.apache.solr.client/org.clojurians.solr.client/' {}
find src/java/org/clojurians -name "*.java" | xargs -I {} sed -i '.bk' 's/org.apache.solr/org.clojurians.solr/' {}
