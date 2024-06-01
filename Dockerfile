# Usa la imagen base de OpenJDK 17
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el Gradle Wrapper
COPY gradlew .
COPY gradle gradle

# Copia los archivos de configuración de Gradle
COPY build.gradle .
COPY settings.gradle .

# Copia los archivos fuente y recursos
COPY src src

# Da permisos de ejecución al Gradle Wrapper
RUN chmod +x gradlew

# Ejecuta la construcción de la aplicación utilizando el Gradle Wrapper
RUN ./gradlew build

# Expone el puerto en el que se ejecuta la aplicación Spring Boot
EXPOSE 8080

# Define el comando para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "build/libs/torrefactora-0.0.1-SNAPSHOT.jar"]
