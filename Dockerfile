FROM openjdk:17-oracle
COPY build/libs/cinema-0.0.1-SNAPSHOT.jar cinema-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cinema-0.0.1-SNAPSHOT.jar"]