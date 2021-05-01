#!/bin/bash -e

if [ "$#" -ne 1 ]; then
  echo "${0} [PROBLEM_NUM]"
  exit 1
fi

Z00=000000${1}
#echo ${Z00}
Z0=${Z00:(-6)}
#echo ${Z0}
Z0X=${Z0:0:4}xx
#echo ${Z0X}

mkdir -p ${Z0X}
cp -R 000000 ${Z0X}/${Z0}

echo "cd ${Z0X}/${Z0}"
