#!/bin/bash

#get working directory
INVOCATION_ABS_DIR=`pwd`

MISSION_DIR=moos-ivp-extend/missions/uuvExemplar

CONFIG_FILE=mission.config

CONTROLLER_DIR=UUV_Controller

JUST_BUILD="no"


#-------------------------------------------------------------------
#  Part 1: Check for and handle command-line arguments
#-------------------------------------------------------------------
for ARGI; do
    if [ "${ARGI}" = "--just_build" -o "${ARGI}" = "-j" ]; then
      JUST_BUILD="yes"
    else
  		printf "Bad Argument: %s \n" $ARGI
  		exit 0
    fi
done



#-------------------------------------------------------
#  Part 2: Parse configuration file
#-------------------------------------------------------
# Arg1: configuration file
# Arg2: Controller's directory
# Arg3: Missions directory

java -jar UUV_DSL.jar $CONFIG_FILE $CONTROLLER_DIR $MISSION_DIR

if [[ $? -eq 0 ]]; then
  printf "Error parsing configuration file. Building aborted!\n"
  exit 0
fi
cd $INVOCATION_ABS_DIR



#-------------------------------------------------------
#  Part 3: Create the .moos and .bhv files.
#-------------------------------------------------------
printf "Creating UUV mission and behaviour files\n"

#go to missions directory
cd $MISSION_DIR

#create mission
nsplug meta_vehicle.moos targ_uuv.moos

cd $INVOCATION_ABS_DIR



#-------------------------------------------------------
#  Part 4: Compile the controller
#-------------------------------------------------------
printf "\nCreating UUV controller\n"

#go to initial directory & then to controller's directory
cd $CONTROLLER_DIR

mvn package

if [ -d "resources" ]; then
  cp -r resources target/
fi

# ls -l

printf "\nUUV controller created successfully\n"

cd $INVOCATION_ABS_DIR
