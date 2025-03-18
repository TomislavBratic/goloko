# Use OpenJDK as base image
FROM eclipse-temurin:21

# Set working directory inside the container
WORKDIR /app

# Copy the application code
COPY . .


# Build the application (optional, if using Maven Wrapper) and give execute rights
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests -Dspring.flyway.enabled=false

# Expose port for Spring Boot
EXPOSE 8080

# Run the Spring Boot application


# Running JAR files are better on production so we dont expose raw java files and directly runs the code, without optimizing code
#CMD ["java", "-jar", "target/goloko.jar"]


# Make the script executable
RUN chmod +x docker-entrypoint.sh

CMD ["sh", "./docker-entrypoint.sh"]