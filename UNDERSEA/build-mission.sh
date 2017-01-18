#!/bin/bash

#get working directory
HOME=`pwd`

MISSION_DIR=moos-ivp/missions/uuvExemplar

CONFIG_FILE=mission.config

CONTROLLER_DIR=UUV_Controller

BUILD_DIR="$HOME/build"

#export DYLD_LIBRARY_PATH=$HOME/$CONTROLLER_DIR/repo/prism

#-------------------------------------------------------------------
#  Part 1: Create build directory if does not exist
#-------------------------------------------------------------------
if [ ! -d "$BUILD_DIR" ]; then
  mkdir build
fi

#-------------------------------------------------------
#  Part 2: Parse configuration file
#-------------------------------------------------------
# Arg1: configuration file
# Arg2: Controller's directory
# Arg3: Missions directory

printf "Gerenating UUV mission given in %s\n" $CONFIG_FILE

java -jar .UUV_DSL.jar $CONFIG_FILE $CONTROLLER_DIR $MISSION_DIR

if [[ $? -eq 0 ]]; then
  printf "Error parsing configuration file. Building aborted!\n"
  exit 0
fi

cd $HOME


#-------------------------------------------------------
#  Part 3: Create the .moos and .bhv files.
#-------------------------------------------------------
printf "Creating UUV mission and behaviour files\n"

#go to missions directory
cd $MISSION_DIR

#create mission
nsplug meta_vehicle.moos targ_uuv.moos

sleep 1
cp targ_uuv.moos $BUILD_DIR/targ_uuv.moos
cp targ_uuv.bhv $BUILD_DIR/targ_uuv.bhv

cd $HOME

#printf "\nWell done. Now, either compile a controller by running the build-controller script or start the experiment by running the launch script\n"
