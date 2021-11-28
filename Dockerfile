FROM openjdk:11.0.1-jdk-slim
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 8080
ENV JAVA_OPTS=""
#ENTRYPOINT exec java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9999 -jar /app.jar
ENTRYPOINT exec java -jar /app.jar
