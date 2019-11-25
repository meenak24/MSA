FROM openjdk:8-jdk-alpine
COPY Act2-0.0.1-SNAPSHOT.war /app.war
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/app.war"]