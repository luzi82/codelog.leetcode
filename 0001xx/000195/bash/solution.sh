#!/bin/bash -e

#cat file.txt | tail -n +10
#cat file.txt | tail -n +10 | head -n 1
cat file.txt | head -n 10 | tail -n +10
