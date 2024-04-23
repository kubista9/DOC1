# Use a base image (e.g., Alpine Linux)
FROM alpine:3.19

# Update package repositories
RUN apk update

# Install OpenJDK 19 (Note: OpenJDK 19 does not exist; you might need to install a different version)
RUN apk add --no-cache openjdk11-jre

# Expose port 8080 (this is the correct syntax)
EXPOSE 8080

# Create a volume (if needed)
VOLUME /backend_volume

# Add the jar file
ADD /target/*.jar docker-demo-0.0.1-SNAPSHOT.jar

# Start the application
ENTRYPOINT ["java", "-jar", "/docker-demo-0.0.1-SNAPSHOT.jar"]
