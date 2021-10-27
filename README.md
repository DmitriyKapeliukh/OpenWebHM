# OpeenWebHM

```bash
python3 -m virtualenv venv
source venv/bin/activate
pip install --requirement requirements.txt
ride.py
```
---


## Test Report

A report of lastest pipeline available on ${projectDir}/target/site/serenity/index.html

## Run tests inside the docker

```bash
docker run -it --rm -v "$(pwd)":/opt/maven -w /opt/maven markhobson/maven-chrome:jdk-15 mvn clean verify
```

---

## Run tests locally

###  Install JDK version 15 or higher
```shell
brew install java
```

### Install Maven

```bash
brew ustall maven@3.5
```

### Run test
```
mvn clean verify
```

## Important!

By default, the test runs in Chrome browser headless mode. If you want to see locally browser interaction just comment 'chrome.switches=--headless;--disable-dev-shm-usage;' property in the 'serenity.properties' file (e.g -> '#chrome.switches=--headless;--disable-dev-shm-usage;')  
