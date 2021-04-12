#!/bin/bash -e

kotlinc Test.kt ParkingSystem.kt -include-runtime -d output.jar
java -jar output.jar
