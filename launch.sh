#!/bin/bash

#get working directory
INVOCATION_ABS_DIR=`pwd`

MISSION_DIR=moos-ivp-extend/missions/uuvExemplar

CONTROLLER_DIR=UUV_Controller

BUILD="no"


#-------------------------------------------------------------------
#  Part 1: Check for and handle command-line arguments
#-------------------------------------------------------------------
for ARGI; do
    if [ "${ARGI}" = "--help" -o "${ARGI}" = "-h" ] ; then
    	printf "%s [SWITCHES]                       \n" $0
    	printf "Switches:                           \n"
    	printf "  --help, -h                        \n"
            printf "  --debug,   -d                     \n"
            printf "  --release, -r                     \n"
    	printf "Notes:                              \n"
    	printf " (1) All other command line args will be passed as args    \n"
    	printf "     to \"make\" when it is eventually invoked.            \n"
    	printf " (2) For example -k will continue making when/if a failure \n"
    	printf "     is encountered in building one of the subdirectories. \n"
    	printf " (3) For example -j2 will utilize a 2nd core in the build  \n"
    	printf "     if your machine has two cores. -j4 etc for quad core. \n"
    	exit 0;
    elif [ "${ARGI}" = "--debug" -o "${ARGI}" = "-d" ] ; then
        BUILD_TYPE="Debug"
    elif [ "${ARGI}" = "--release" -o "${ARGI}" = "-r" ] ; then
        BUILD_TYPE="Release"
    elif [ "${ARGI}" = "--build" -o "${ARGI}" = "-b" ]; then
      BUILD="yes"
    else
  		printf "Bad Argument: %s \n" $ARGI
  		exit 0
    fi
done



#-------------------------------------------------------
#  Part 2: Create the .moos and .bhv files.
#-------------------------------------------------------
if [ ${BUILD} = "yes" ]; then
	printf "Building UUV and controller\n"
  ./build.sh
fi


#-------------------------------------------------------
#  Part 3: Launch the shoreside, the UUV & its controller
#-------------------------------------------------------
#go to missions directory
cd $MISSION_DIR

#start uuv simulator
pAntler targ_uuv.moos >& /dev/null &

sleep 3

#go to initial directory & then to controller's directory
cd $INVOCATION_ABS_DIR/$CONTROLLER_DIR

#start controller
java -jar target/UUV_Controller-jar-with-dependencies.jar
EXIT_VALUE=$?

if [[ $EXIT_VALUE -eq 1 ]]; then
  cd $INVOCATION_ABS_DIR
  ./clean.sh -k
fi
