FROM gcr.io/distroless/java:11

COPY HelloEnvAPI-0.0.1-SNAPSHOT-fat.jar /apps/

WORKDIR /apps

EXPOSE 9595
ENTRYPOINT ["java","-jar", "HelloEnvAPI-0.0.1-SNAPSHOT-fat.jar"]