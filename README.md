# Appium Test

## Overview
The following repo contains implementation of health check suite for 'VODQA' apk.

## Guidelines
To be able to execute test suite follow the next steps:

### Pre-steps
1. Install Android SDK. The most convenient way to use Android Studio.
2. Install Java SDK(java version "1.8.0_231" is preferable in order to avoid issues with UI Automator Viewer )
3. Install Node.js (https://nodejs.org/en/download)
4. Create virtual device via Android Studio. After device creating. Execute 'adb devices' in order to check that device created successfully
5. Setting up env variables:JAVA_HOME, MAVEN_HOME, ANDROID_HOME. Also add to 'PATH' following package from Android SDK(platform-tools, tools, tools/bin, emulator)
6. Install Appium via nmp (npm i --location=global appium)

### Steps
1. Repo already cloned =)
2.  run command: mvn -test
3. As a result appeared cucumber report at path: target/cucumber-report.html
4. Doen
