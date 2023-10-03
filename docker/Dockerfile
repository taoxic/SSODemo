
FROM ubuntu:22.04

# Install some utilities
RUN apt-get update \
     && apt-get -y dist-upgrade \
     && apt-get -y --purge autoremove \
     && apt-get install -y openjdk-8-jdk-headless \
     && apt-get autoclean \
     && apt-get clean \
     && rm -rf /var/lib/apt/lists/*

COPY *.jar /app.jar

ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64

ENTRYPOINT ["java","-jar","/app.jar"]