# Use an OpenJDK image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /task-manager-service

# Copy the Spring Boot JAR file
COPY build/libs/task-manager-service-*.jar ./task-manager-service.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "task-manager-service.jar"]
