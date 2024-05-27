FROM maven:3.9.6-amazoncorretto-21 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM amazoncorretto:21
WORKDIR /application
COPY --from=builder /app/target/*.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "application.jar"]

