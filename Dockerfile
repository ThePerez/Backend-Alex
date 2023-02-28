    FROM amazoncorretto:11-alpine-jdk 
    MAINTAINER AlexPerez
    COPY target/alex_Project-0.0.1-SNAPSHOT.jar alexPerez_project.jar
    ENTRYPOINT ["java","-jar","/alexPerez_project.jar"] 
