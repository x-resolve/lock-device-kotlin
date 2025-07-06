#!/usr/bin/env sh

# Descarga automática de gradle-wrapper.jar si no existe
if [ ! -f "gradle/wrapper/gradle-wrapper.jar" ]; then
  echo "Descargando gradle-wrapper.jar..."
  mkdir -p gradle/wrapper
  curl -sSL https://services.gradle.org/distributions/gradle-8.2-wrapper.jar -o gradle/wrapper/gradle-wrapper.jar
fi

GRADLE_WRAPPER_PROPERTIES=gradle/wrapper/gradle-wrapper.properties
if [ ! -f "$GRADLE_WRAPPER_PROPERTIES" ]; then
  echo "Falta gradle-wrapper.properties"
  exit 1
fi

exec java -jar gradle/wrapper/gradle-wrapper.jar "$@"
