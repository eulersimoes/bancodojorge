FROM openjdk:17-alpine

ARG SRC_JAR=apirest/target/apirest.jar

ENV BANCO_BACKEND_JAR=/opt/bancojorge/apirest.jar
ENV BANCO_LOGS_DIR=/var/log/app-logs
ENV MAXHEAP="1600m"

RUN mkdir -p $BANCO_LOGS_DIR # & mkdir -p $BANCO_BACKEND_JAR 

COPY $SRC_JAR $BANCO_BACKEND_JAR

#-----------------------------------------
ENTRYPOINT  java -DPOSTGRES_HOST=postgresql-bancojorge -Xmx$MAXHEAP -jar $BANCO_BACKEND_JAR --banco.logging.directory=$BANCO_LOGS_DIR

