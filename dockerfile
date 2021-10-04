FROM openjdk:16-jdk-alpine
EXPOSE 8080
COPY target/*.jar app.jar
ENTRYPOINT sh -c 'while ! nc -z 0.0.0.0 5432; do sleep 1; echo "nope"; done; java -jar /app.jar'
