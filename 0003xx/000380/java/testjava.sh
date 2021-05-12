#!/bin/bash -e

javac -Xlint:unchecked Test.java
java  Test

echo PASS
