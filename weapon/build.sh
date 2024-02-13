#!/usr/bin/env bash
function main() {
    JAVA_HOME=/usr/lib/jvm/java-17 mvn clean verify
    docker build .
}

main "$@"
