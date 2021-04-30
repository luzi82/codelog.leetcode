#!/bin/bash -e

kotlinc Test.kt Solution.kt -include-runtime -d output.jar
java -jar output.jar
