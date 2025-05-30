FROM openjdk:21-jdk-slim
COPY target/ms-formation*.jar ms-formation.jar
ENTRYPOINT ["java", "-jar", "/ms-formation.jar"]
EXPOSE 8082
