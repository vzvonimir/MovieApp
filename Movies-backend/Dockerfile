FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/movies-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} movies.jar
ENTRYPOINT ["java","-jar","/movies.jar"]
EXPOSE 8080