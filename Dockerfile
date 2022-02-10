FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Calculator-Service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Calculator-Service-0.0.1-SNAPSHOT.jar"]
