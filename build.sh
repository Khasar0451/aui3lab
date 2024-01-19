#!/usr/bin/env bash

function main(){
  cd ./dwarf/; sh ./build.sh; cd ..
  cd ./weapon/; sh ./build.sh; cd ..
  cd ./gateway/; sh ./build.sh; cd ..
  cd ./angular/; sh ./build.sh; cd ..
}

main "$@"