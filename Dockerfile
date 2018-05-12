### Builder Image

FROM maven:3-jdk-10 as builder

WORKDIR /app

## Maven dependencies
COPY pom.xml .
RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.0.2:go-offline

## Maven package
COPY src ./src
RUN mvn -B -e -o -T 1C package


### Runner Image

FROM openjdk:10-jre-slim

WORKDIR /server

COPY --from=builder /app/target/starter*.war ./target/
EXPOSE 8080

CMD java -jar ./target/*.war
