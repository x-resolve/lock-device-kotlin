@echo off
setlocal

set GRADLE_WRAPPER_PROPERTIES=gradle\wrapper\gradle-wrapper.properties

if not exist "%GRADLE_WRAPPER_PROPERTIES%" (
  echo Missing %GRADLE_WRAPPER_PROPERTIES%, please reconfigure Gradle wrapper.
  exit /b 1
)

call gradlew.bat wrapper --gradle-version 8.2 || exit /b 1
call gradlew.bat %*