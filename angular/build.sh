#!/usr/bin/env bash

main () {
  npm install
  npm run build
  docker build .
}

main "$@"
