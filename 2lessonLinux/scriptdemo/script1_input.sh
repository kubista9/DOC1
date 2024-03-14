#!/usr/bin/sh

if [ -p /dev/stdin ]; then
	# Check to see if stdin is connected to a pipe
	echo "Got data from a pipe"
elif [ -f /dev/stdin ]; then
	# Check to see if stdin is connected to a regular file
	echo "Got data on stdin"
elif [ $# -gt 0 ]; then
	# Check to see if any command line arguments were given
	echo "Got cmdline argument(s): " "${@}"
else
	# This script was not given any kind of data
	read -r -p "No data given, please enter a file name: " USERFILE
    echo "The user wrote '${USERFILE}'"	
fi
