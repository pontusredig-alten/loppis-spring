FROM openjdk:11
COPY ./target/loppis-0.0.1-SNAPSHOT.jar /usr/src/loppis/
WORKDIR /usr/src/loppis
EXPOSE 8080
CMD ["java", "-jar", "loppis-0.0.1-SNAPSHOT.jagr"]