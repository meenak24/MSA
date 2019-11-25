EXPOSE 8090
FROM openjdk:8-jdk-alpine
COPY DockerApp-0.0.1-SNAPSHOT.war /app.war
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/app.war"]