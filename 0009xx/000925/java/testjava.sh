#!/bin/bash

set -e

javac -Xlint:unchecked Test.java
java  Test
