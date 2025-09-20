# Build stage
FROM maven:3.9-eclipse-temurin-23 AS build

WORKDIR /app

# Copy pom.xml first for dependency caching
COPY pom.xml .
# Download dependencies only (optimizes Docker cache)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application (include tests if you want)
RUN mvn clean package -B -DskipTests

# Runtime stage - using JRE only for smaller image
FROM eclipse-temurin:23-jre

WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Set entry point to run the game
ENTRYPOINT ["java", "-jar", "app.jar"]