# Build stage
FROM gradle:8.4-jdk17 AS build
WORKDIR /app
COPY .. .
RUN gradle :inventory-service:bootJar

# Runtime stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/inventory-service/build/libs/inventory-service-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
