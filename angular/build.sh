#!/usr/bin/env bash
function main() {
    npm run build
    docker build
}

main "$@"
