FROM devblogs1/java-agent:1.0

RUN mkdir -p /usr/app
WORKDIR /usr/app

COPY target/storage-test-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "storage-test-0.0.1-SNAPSHOT.jar"]