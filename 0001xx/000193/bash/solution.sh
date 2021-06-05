#!/bin/bash -e

cat file.txt | grep -E "^(([[:digit:]]{3}-[[:digit:]]{3}-[[:digit:]]{4})|(\\([[:digit:]]{3}\\) [[:digit:]]{3}-[[:digit:]]{4}))$"

#echo "(123) 456-7890" | grep -E "^\\([[:digit:]]{3}\\) [[:digit:]]{3}-[[:digit:]]{4}$" # ok
#echo "987-123-4567" | grep -E "^[[:digit:]]{3}-[[:digit:]]{3}-[[:digit:]]{4}$" # ok

#echo "(123) 456-7890" | grep -E "^([[:digit:]]{3}-[[:digit:]]{3}-[[:digit:]]{4})|(\\([[:digit:]]{3}\\) [[:digit:]]{3}-[[:digit:]]{4})$" # ok
#echo "987-123-4567" | grep -E "^([[:digit:]]{3}-[[:digit:]]{3}-[[:digit:]]{4})|(\\([[:digit:]]{3}\\) [[:digit:]]{3}-[[:digit:]]{4})$" # ok

#echo "0(001) 345-0000" | grep -E "^([[:digit:]]{3}-[[:digit:]]{3}-[[:digit:]]{4})|(\\([[:digit:]]{3}\\) [[:digit:]]{3}-[[:digit:]]{4})$" # false+
#echo "x(001) 345-0000" | grep -E "^([[:digit:]]{3}-[[:digit:]]{3}-[[:digit:]]{4})|(\\([[:digit:]]{3}\\) [[:digit:]]{3}-[[:digit:]]{4})$" # false+
#echo "x(001) 345-0000" | grep -E "^(\\([[:digit:]]{3}\\) [[:digit:]]{3}-[[:digit:]]{4})$" # ok
#echo "x(001) 345-0000" | grep -E "^(([[:digit:]]{3}-[[:digit:]]{3}-[[:digit:]]{4})|(\\([[:digit:]]{3}\\) [[:digit:]]{3}-[[:digit:]]{4}))$" # ok
