mv src/java/org/apache src/java/org/clojurians
find src/java/org/clojurians -name "*.java" | xargs -I {} sed -i '.bk' 's/org.apache.solr.common/org.clojurians.solr.common/' {}
find src/java/org/clojurians -name "*.java" | xargs -I {} sed -i '.bk' 's/org.apache.solr.client/org.clojurians.solr.client/' {}
find src/java/org/clojurians -name "*.java" | xargs -I {} sed -i '.bk' 's/org.apache.solr/org.clojurians.solr/' {}

java -cp solr-5.5.1/solr/server/start.jar  org.eclipse.jetty.start.Main
java -jar /Users/larluo/work/git/cluster-dev/.clojurians-org/tarball/solr-6.5.1/server/start.jar STOP.PORT=7983 STOP.KEY=solrrocks --stop

cd solr-5.5.1/solr && ant compile && ant dist
cd solr-5.5.1/solr/web-app && ant compile && ant dist

export SOLR_PREFIX=/Users/larluo/work/git/solr-clj/solr-5.5.1/solr
java -Dsolr.install.dir=$SOLR_PREFIX -Dlog4j.configuration=file:$SOLR_PREFIX/server/scripts/cloud-scripts/log4j.properties -classpath "$SOLR_PREFIX/server/solr-webapp/webapp/WEB-INF/lib/*:$SOLR_PREFIX/server/lib/ext/*" org.apache.solr.util.SolrCLI run_example -e cloud -d $SOLR_PREFIX/server -urlScheme http
