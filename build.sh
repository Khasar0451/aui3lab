function main(){
  cd ./dwarf/; sh ./build.sh; cd ..
  cd ./weapon/; sh ./build.sh; cd ..
  cd ./gateway/; sh ./build.sh; cd ..
  cd ./DRG-js/; sh ./build.sh; cd ..
}

main "$@"