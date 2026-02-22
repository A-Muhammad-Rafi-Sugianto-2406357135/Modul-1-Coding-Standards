FROM docker.io/library/eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /src/advshop
COPY . .
RUN chmod +x gradlew
RUN ./gradlew clean bootJar


FROM docker.io/library/eclipse-temurin:21-jre-alpine AS runner

WORKDIR /opt/advshop
COPY --from=builder /src/advshop/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java"]
CMD ["-jar", "app.jar"]