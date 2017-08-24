FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/sonda-0.0.1-SNAPSHOT.jar sonda.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /sonda.jar" ]