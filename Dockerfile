# Build stage
FROM gradle:8.4-jdk17 AS build

WORKDIR /app

COPY settings.gradle build.gradle gradle.properties gradle/ ./

COPY pos-common ./pos-common
COPY pos-order-service ./pos-order-service
COPY pos-inventory-service ./pos-inventory-service
COPY pos-api-gateway ./pos-api-gateway

WORKDIR /app/pos-inventory-service
RUN gradle bootJar --no-daemon

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/pos-inventory-service/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
