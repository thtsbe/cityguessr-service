FROM openjdk:11-jre-slim-buster
COPY target/cityguessr-service-0.0.1-SNAPSHOT.jar /home/cityguessr-service.jar
CMD ["java", "-jar", "/home/cityguessr-service.jar"]
