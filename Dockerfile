FROM openjdk:8
COPY ./target/devops_pipeline-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "devops_pipeline-1.0-SNAPSHOT-jar-with-dependencies.jar"]