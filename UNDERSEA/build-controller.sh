#!/bin/bash

#get working directory
HOME=`pwd`

MISSION_DIR=moos-ivp-extend/missions/uuvExemplar

CONFIG_FILE=mission.config

CONTROLLER_DIR=UUV_Controller

BUILD_DIR="$HOME/build"


#-------------------------------------------------------------------
#  Part 1: Create build directory if does not exist
#-------------------------------------------------------------------
if [ ! -d "$BUILD_DIR" ]; then
  mkdir build
fi


#-------------------------------------------------------------------
#  Part 2: Create the controller
#-------------------------------------------------------------------
printf "\nCreating UUV controller\n"

#go to initial directory & then to controller's directory
cd $CONTROLLER_DIR

mvn package

JAR="target/UUV_Controller-jar-with-dependencies.jar"

if [ -e "$JAR" ]; then
  cp $JAR $BUILD_DIR/UUV_Controller.jar
fi


if [ ! -d "$BUILD_DIR/resources" ]; then
  cp -r resources $BUILD_DIR/
fi

printf "\nUUV controller created successfully\n"

cd $HOME


#PCM-based controller
cd $CONTROLLER_DIR

if [ ! -d "$BUILD_DIR/models" ]; then
  cp -r models $BUILD_DIR/
fi

if [ ! -d "$BUILD_DIR/repo" ]; then
  cp -r repo $BUILD_DIR/
fi

cd $HOME
