#!/usr/bin/env sh

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Generate wrapper if missing
if [ ! -f "gradle/wrapper/gradle-wrapper.properties" ]; then
  echo "Missing gradle-wrapper.properties"
  exit 1
fi

./gradlew wrapper --gradle-version 8.2 || exit 1
exec ./gradlew "$@"