// File: gradlew
#!/usr/bin/env sh

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

GRADLE_WRAPPER_PROPERTIES=gradle/wrapper/gradle-wrapper.properties

if [ ! -f "$GRADLE_WRAPPER_PROPERTIES" ]; then
  echo "Missing $GRADLE_WRAPPER_PROPERTIES, please reconfigure Gradle wrapper."
  exit 1
fi

exec ./gradle/wrapper/gradle-wrapper.jar "$@"
