FROM openjdk:8
COPY ./target/devops_pipeline-1.0-SNAPSHOT.jar ./
WORKDIR ./
CMD ["java", "-cp", "devops_pipeline-1.0-SNAPSHOT.jar", "HelloWorld"]