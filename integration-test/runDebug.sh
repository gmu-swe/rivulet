#!/bin/bash

cd "$(dirname "$0")" || exit
mkdir -p target

cp ../config-files/integration-test/sources target/sources
cp ../config-files/demo/sinks target/sinks && echo $'\n\n' >> target/sinks && cat ../config-files/integration-test/sinks >> target/sinks
cp ../config-files/demo/taintThrough target/taintThrough && echo $'\n\n' >> target/taintThrough && cat ../config-files/integration-test/taintThrough >> target/taintThrough

AUTO_TAINT="-Dphosphor.sources=target/sources -Dphosphor.sinks=target/sinks -Dphosphor.taintThrough=target/taintThrough"
DEBUG="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005 -Xnoagent -Djava.compiler=NONE"

../apache-maven-phosphor/bin/mvn ${AUTO_TAINT} -Dmaven.surefire.debug="$DEBUG" -DfailIfNoTests=false test