FROM payara/server-full:5.2022.4-jdk17

# Download the JDBC driver
USER root
RUN apt-get update && \
    apt-get install -y wget unzip && \
    rm -rf /var/lib/apt/lists/* && \
    wget https://repo1.maven.org/maven2/postgresql/postgresql/9.1-901.jdbc4/postgresql-9.1-901.jdbc4-javadoc.jar \
         -O /tmp/postgresql.jar

USER payara

# this script adds a jdbc connection pool and ressource
COPY post-boot-commands.asadmin $POSTBOOT_COMMANDS

#COPY myapplication.war $DEPLOY_DIR
