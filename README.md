# aws-blue-green-deploy

Simple REST API to evaluate Blue-Green Deployment release technique using Amazon AWS.

#Building the Docker image

```
docker build -t aws-blue-green-deploy .
```

##Building the Docker image behing a proxy

If you are behind a proxy you can build with the following command:

```
docker build --build-arg MAVEN_OPTS='-Dhttp.proxyHost=10.96.161.85 -Dhttp.proxyPort=3128 -Dhttps.proxyHost=10.96.161.85 -Dhttps.proxyPort=3128' -t aws-blue-green-deploy .
```

##Running the container

```
docker run -p 8080:8080 --rm --name blue-green-app aws-blue-green-deploy
```
