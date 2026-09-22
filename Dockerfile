FROM eclipse-temurin:17-jre

RUN groupadd -r app && useradd -r -g app app

WORKDIR /app

COPY target/banco-facil-api-0.0.1-SNAPSHOT.jar app.jar

USER app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
