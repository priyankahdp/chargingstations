FROM openjdk:16-jdk-oracle
ADD target/chargingstation.jar chargingstation.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "chargingstation.jar"]