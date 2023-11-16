FROM maven:3.8.3-openjdk-17

WORKDIR /app

RUN git clone https://github.com/Ruan-Hasselmann/Crediario-Back.git

WORKDIR /app/Crediario-Back

EXPOSE 8080

CMD mvn clean spring-boot:run -DskipTests