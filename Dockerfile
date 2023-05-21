# Stage 1: Build the application
FROM docker.io/maven:3.9.2-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src

RUN mvn clean package
RUN ls -lrt /app/
RUN ls -lrt /app/target/


# Stage 2: Create the final image
FROM docker.io/amazoncorretto:17.0.7-alpine
WORKDIR /app
COPY --from=build /app/target/kafka-protobuf-consumer-0.0.1-SNAPSHOT.jar .

EXPOSE 8080
CMD ["java", "-jar", "kafka-protobuf-consumer-0.0.1-SNAPSHOT.jar"]
