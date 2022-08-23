FROM openjdk:11
WORKDIR usr/src
COPY target/authjar.jar ./
ENTRYPOINT ["java","-jar","authjar.jar"]