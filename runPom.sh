#!/bin/bash

usage()
{
    echo usage: $0 [options] [path-to-pom]
    echo -e "\nOptions:"
    echo -e " -X, --debug\t\tAdd debugging arguments"
    echo -e "  *, Anything else will be appended to the arguments line"
}

arg_line=""
debug=false
path="$(cd "$(dirname "$0")" && pwd)"
DEBUG_ARGS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005 -Xnoagent -Djava.compiler=NONE"


# Ensure that at least one argument was specified
if [[ "$#" -lt "1" ]]; then
    usage
    exit 1
fi

# Pop the pom file argument off the end of the arguments
pom=${@: -1}
set -- "${@:1:$(($#-1))}"

# Check the other options
while [[ "$1" != "" ]]; do
    case $1 in
    -h | --help )           usage
                            exit
                            ;;
    -X | --debug )          debug=true
                            ;;
    * )                     arg_line="$arg_line $1"
    esac
    shift
done

USER_PROPS="-Dsurefire.timeout=0 -DfailIfNoTests=false -Dmaven.test.failure.ignore -Dsurefire.rerunFailingTestsCount=0 -Difc.criticalReproductionFiles"

if ${debug}; then
    echo "${path}/apache-maven-phosphor/bin/mvn -f ${pom} ${AUTO_TAINT} ${arg_line} ${USER_PROPS} -Dmaven.surefire.debug="${DEBUG_ARGS}" test"
    ${path}/apache-maven-phosphor/bin/mvn -f ${pom} ${AUTO_TAINT} ${arg_line} ${USER_PROPS} -Dmaven.surefire.debug="$DEBUG_ARGS" test
else
    echo "${path}/apache-maven-phosphor/bin/mvn -f ${pom} ${AUTO_TAINT} ${arg_line} ${USER_PROPS} test"
    ${path}/apache-maven-phosphor/bin/mvn -f ${pom} ${AUTO_TAINT} ${arg_line} ${USER_PROPS} test
fi

