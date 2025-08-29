FROM openjdk:24-jdk-slim

COPY target/web-app-0.0.1-SNAPSHOT.jar app/web-app-0.0.1-SNAPSHOT.jar

WORKDIR /app

EXPOSE 8080

ENV SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3307/web-app-db

ENTRYPOINT ["java", "-jar", "web-app-0.0.1-SNAPSHOT.jar"]