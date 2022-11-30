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
COPY post-boot-commands.asadmin $POSTBOOT_COMMANDS

#COPY myapplication.war $DEPLOY_DIR
