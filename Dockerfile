#Dockerfile
FROM openjdk:17-jdk-alpine AS build
WORKDIR /build

COPY . /build/
RUN ./gradlew bootJar

FROM openjdk:17-jdk-alpine
ARG JAR_FILE=/build/build/libs/mobility-service.jar
COPY --from=build ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
