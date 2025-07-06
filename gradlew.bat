@echo off
setlocal

set GRADLE_WRAPPER_PROPERTIES=gradle\wrapper\gradle-wrapper.properties

if not exist "%GRADLE_WRAPPER_PROPERTIES%" (
  echo Missing %GRADLE_WRAPPER_PROPERTIES%, please reconfigure Gradle wrapper.
  exit /b 1
)

java -jar gradle\wrapper\gradle-wrapper.jar %*
