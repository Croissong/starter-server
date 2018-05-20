### Builder Image

FROM maven:3-jdk-10 as builder

WORKDIR /app

## Maven dependencies
COPY pom.xml .
RUN mvn -B -e -C -T 1C dependency:go-offline

## Maven package
COPY src ./src
COPY config ./config
RUN mvn -B -e -o -T 1C package


### Runner Image

FROM openjdk:10-jre-slim

WORKDIR /server
VOLUME /server/config
COPY --from=builder /app/target/starter*.jar ./target/
EXPOSE 8080
EXPOSE 5005

# CMD java -Xdebug -Xrunjdwp:transport=dt_socket,address=*:5005,server=y,suspend=n -jar ./target/*.jar
CMD java -jar ./target/*.jar
