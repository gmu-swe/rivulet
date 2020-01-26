#!/bin/bash

cd "$(dirname "$0")" || exit
mkdir -p target

MAVEN_FLAGS=""

if [[ -n "$PROFILE" ]] ; then
	MAVEN_FLAGS="-P $PROFILE"
fi

while getopts ":q" opt; do
  case $opt in
    q)
      MAVEN_FLAGS+=" -B -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn -Difc.disableViolationPrinting -Difc.noAnsiEscape"
      ;;
    \?)
      echo "Invalid option: -$OPTARG" >&2
      ;;
  esac
done


echo mvn ${MAVEN_FLAGS} test
mvn ${MAVEN_FLAGS} test
