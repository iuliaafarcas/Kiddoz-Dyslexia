FROM openjdk:17-jdk-slim

WORKDIR /kiddoz_dyslexia

COPY ./build/libs/dyslexia-0.0.1-SNAPSHOT.jar /kiddoz_dyslexia/myapp.jar

CMD ["java", "-jar", "myapp.jar"]
