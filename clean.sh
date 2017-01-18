#!/bin/bash

#get working directory
INVOCATION_ABS_DIR=`pwd`


VERBOSE=""
KILLALL="no"
REMOVE="no"
function killAll {
	# processesShoreside=("pAntler" "MOOSDB" "uProcessWatch" "uTimerScript" "pHostInfo" "pShare" "uFldShoreBroker" "uFldNodeComms" pMarineViewer)
	processesVehicle=(MOOSDB uProcessWatch uSimMarine pNodeReporter pMarinePID pHelmIvP sSensor sUUV pMarineViewer pAntler)
	#printf "Shoreside:\t"
	for i in ${processesShoreside[@]}; do
		printf "%s\t" ${i}
		kill -9 $(ps aux | grep ${i} | awk '{print $2}')
	done
	#printf "\nVehicle:\ts"
	for i in ${processesVehicle[@]}; do
		#printf "%s\t" ${i}
		kill -9 $(ps aux | grep ${i} | awk '{print $2}') >& /dev/null &
	done
	echo
}

#-------------------------------------------------------
#  Part 1: Check for and handle command-line arguments
#-------------------------------------------------------
for ARGI; do
    if [ "${ARGI}" = "--help" -o "${ARGI}" = "-h" ] ; then
	printf "%s [SWITCHES]                       \n" $0
	printf "  --verbose                         \n"
	printf "  --help, -h                        \n"
	exit 0;
	elif [ "${ARGI}" = "kill" -o "${ARGI}" = "-k" ] ; then
		KILLALL="yes"
	elif [ "${ARGI}" = "remove" -o "${ARGI}" = "-r" ] ; then
		REMOVE="yes"
    elif [ "${ARGI}" = "--verbose" -o "${ARGI}" = "-v" ] ; then
	VERBOSE="-v"
    else
	printf "Bad Argument: %s \n" $ARGI
	exit 0
    fi
done


#-------------------------------------------------------
#  Part 2: Do the cleaning!
#-------------------------------------------------------
if [ ${KILLALL} = "yes" ]; then
	printf "Shutting down MOOS-IvP!\n"
	#kill -9 $(ps aux | grep "pAntler"   | awk '{print $2}') >& /dev/null &
	killAll
fi

if [ ${REMOVE} = "yes" ]; then
	printf "Cleaning mission files\n"
	cd moos-ivp-extend/missions/uuvExemplar

	rm -f    .LastOpenedMOOSLogDirectory
	rm -rf  $VERBOSE MOOSLog_*  LOG_*
	rm -rf  $VERBOSE *~ targ_* *.moos++ log *SENSOR*.moos *UUV*.moos
	rm -f logfile/*

	cd $INVOCATION_ABS_DIR
fi
