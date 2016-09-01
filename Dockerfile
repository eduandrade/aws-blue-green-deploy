FROM openjdk:8-jdk-alpine

COPY target /code/target

WORKDIR /code

EXPOSE 8080

CMD ["java", "-jar", "target/aws-blue-green-deploy.jar"]
