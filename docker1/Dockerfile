FROM openjdk:17-jdk-alpine
MAINTAINER baeldung.com
COPY build/libs/docker1-0.0.1-SNAPSHOT.jar message-server-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/message-server-1.0.0.jar"]