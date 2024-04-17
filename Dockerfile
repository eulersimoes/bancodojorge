FROM openjdk:17-alpine

ARG SRC_JAR=apirest/target/apirest.jar
ARG SRC_FRONTEND_DIR=

ENV BANCO_BACKEND_JAR=/opt/bancojorge/apirest.jar
ENV BANCO_LOGS_DIR=/var/log/app-logs
ENV MAXHEAP="1600m"

RUN mkdir -p $BANCO_LOGS_DIR # & mkdir -p $BANCO_BACKEND_JAR 

COPY $SRC_JAR $BANCO_BACKEND_JAR

#-----------------------------------------
ENTRYPOINT  java -Xmx$MAXHEAP -jar $BANCO_BACKEND_JAR --banco.logging.directory=$BANCO_LOGS_DIR

