FROM gradle:6.3.0-jdk11 AS build

COPY --chown=gradle:gradle ./ /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon --stacktrace

FROM openjdk:11.0-jre

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/application.jar

ENTRYPOINT ["java", "-jar", "/app/application.jar"]