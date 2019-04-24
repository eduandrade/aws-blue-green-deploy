# aws-blue-green-deploy

[![CircleCI](https://circleci.com/gh/eduandrade/aws-blue-green-deploy.svg?style=svg)](https://circleci.com/gh/eduandrade/aws-blue-green-deploy)

Simple REST API to evaluate Blue-Green Deployment release technique using Amazon AWS.

# Building the Docker image

```
docker build -t aws-blue-green-deploy .
```

## Building the Docker image behing a proxy

If you are behind a proxy you can build with the following command:

```
docker build --build-arg MAVEN_OPTS='-Dhttp.proxyHost=<host> -Dhttp.proxyPort=<port> -Dhttps.proxyHost=<host> -Dhttps.proxyPort=<port>' -t aws-blue-green-deploy .
```

## Running the container

```
docker run -p 8080:8080 --rm --name blue-green-app aws-blue-green-deploy
```
