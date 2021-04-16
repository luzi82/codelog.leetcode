#!/bin/bash -e

kotlinc Solution.kt Test.kt TreeNode.kt -include-runtime -d output.jar
java -jar output.jar
