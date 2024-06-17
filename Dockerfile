FROM maven:3-openjdk-17 as mvn-build-stage
COPY --chmod=777 apirest/src /apirest/src
COPY --chmod=777 apirest/pom.xml /apirest/pom.xml
WORKDIR /apirest
#REALIZA PACKAGE DO MAVEN ANTES DE GERAR A IMAGEM
RUN mvn clean package -e -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true

FROM openjdk:17-alpine
ARG SRC_JAR=apirest/target/apirest.jar
ENV BANCO_BACKEND_JAR=/opt/bancojorge/apirest.jar
ENV BANCO_LOGS_DIR=/var/log/app-logs
ENV MAXHEAP="1600m"
RUN mkdir -p $BANCO_LOGS_DIR # & mkdir -p $BANCO_BACKEND_JAR 
COPY --from=mvn-build-stage $SRC_JAR $BANCO_BACKEND_JAR
#-----------------------------------------
ENTRYPOINT  java -DPOSTGRES_HOST=postgresql-bancojorge -Xmx$MAXHEAP -jar $BANCO_BACKEND_JAR --banco.logging.directory=$BANCO_LOGS_DIR

