FROM maven:3.8.6-eclipse-temurin-17 as builder

COPY pom.xml /

COPY rest/src /rest/src
COPY rest/pom.xml /rest/pom.xml

COPY business/src /business/src
COPY business/pom.xml /business/pom.xml

COPY jpa/src /jpa/src
COPY jpa/pom.xml /jpa/pom.xml

RUN mvn clean package


FROM payara/server-full:6.2022.1-jdk17
# Download the JDBC driver
USER root
RUN apt-get update && \
    apt-get install -y wget unzip && \
    rm -rf /var/lib/apt/lists/* && \
    wget https://repo1.maven.org/maven2/org/postgresql/postgresql/42.5.1/postgresql-42.5.1.jar \
         -O /tmp/postgresql.jar

USER payara

# this script adds a jdbc connection pool and ressource
COPY mypayara-full/post-boot-commands.asadmin $POSTBOOT_COMMANDS

COPY --from=builder /rest/target/rest.war $DEPLOY_DIR/rest.war
