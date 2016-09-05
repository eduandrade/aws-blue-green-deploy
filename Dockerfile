FROM maven:3-jdk-8-alpine

ARG MAVEN_OPTS=""
ENV MAVEN_OPTS ${MAVEN_OPTS}

COPY . /code

WORKDIR /code

RUN mvn clean install

EXPOSE 8080

CMD ["java", "-jar", "target/aws-blue-green-deploy.jar"]
