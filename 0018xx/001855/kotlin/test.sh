#!/bin/bash -e

kotlinc *.kt -include-runtime -d output.jar
java -jar output.jar
