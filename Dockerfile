FROM openjdk:8
EXPOSE 8099
ADD target/spring-boot-details-docker.jar spring-boot-details-docker.jar 
ENTRYPOINT ["java","-jar","/spring-boot-details-docker.jar"]