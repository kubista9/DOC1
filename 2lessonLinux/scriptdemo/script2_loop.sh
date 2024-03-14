#!/usr/bin/sh


INPUTFILE=''

if [ -p /dev/stdin -o  -f /dev/stdin ]; then
        # Check to see if stdin is connected to anything
        INPUTFILE="/dev/stdin"
elif [ $# -eq 1 ]; then
        # Check to see if a file name was given as argument
        if [ ! -f ${1} ]; then
        	echo "${1} is not a valid file"
        	exit 1
        fi
        INPUTFILE="${1}"
else
        # This script was not given any kind of data
        echo "No data given"
        exit 1
fi

for number in $(sort ${INPUTFILE} | uniq)
do
	echo "I saw $number"
done
