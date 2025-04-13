FROM openjdk:8
EXPOSE 9191
COPY target/justspring-1.0.0.jar justspring-1.0.0.jar
ENTRYPOINT ["java","-jar","./justspring-1.0.0.jar"]