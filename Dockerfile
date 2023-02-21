    FROM amazoncorretto:11-alpine-jdk 
    MAINTAINER AlexPerez
    COPY target/alex_Project-0.0.1-SNAPSHOT.jar alexperez-app.jar
    ENTRYPOINT ["java", "-jar", "/alexperez-app.jar"] 
