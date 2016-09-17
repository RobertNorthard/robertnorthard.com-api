
FROM resin/rpi-raspbian:wheezy
MAINTAINER Robert Northard

RUN apt-get update && apt-get install -y \
    oracle-java8-jdk \
    --no-install-recommends

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-armhf
ENV API_VERSION 0.0.1

WORKDIR /data
ADD target/api-${API_VERSION}.jar /data/api.jar
ADD start.sh /data
RUN chmod +x start.sh
ENTRYPOINT ["/data/start.sh"]“