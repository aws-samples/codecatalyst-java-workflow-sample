FROM amazoncorretto:17-al2023
COPY ./target/*.jar rest-calculator.jar
EXPOSE 8080
USER nobody
CMD java -Xms128m -Xmx512m -jar rest-calculator.jar
