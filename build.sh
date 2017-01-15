#!/bin/bash

#get working directory
INVOCATION_ABS_DIR=`pwd`

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
#go to missions directory
cd moos-ivp-extend/missions/uuvExemplar

java -jar $INVOCATION_ABS_DIR/UUV_DSL.jar $INVOCATION_ABS_DIR/mission.config

cd $INVOCATION_ABS_DIR


#-------------------------------------------------------
#  Part 3: Create the .moos and .bhv files.
#-------------------------------------------------------
printf "Creating UUV mission and behaviour files\n"

#go to missions directory
cd moos-ivp-extend/missions/uuvExemplar

#create mission
nsplug meta_vehicle.moos targ_uuv.moos

printf "UUV mission and behaviour files created successfully\n"
# ls -l

cd $INVOCATION_ABS_DIR



#-------------------------------------------------------
#  Part 4: Compile the controller
#-------------------------------------------------------
printf "\nCreating UUV controller\n"

#go to initial directory & then to controller's directory
cd UUV_Controller

mvn package

if [ -d "resources" ]; then
  cp -r resources target/
fi

# ls -l

printf "\nUUV controller created successfully\n"
