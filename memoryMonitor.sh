#!/bin/bash

CONTROLLER=UUV_Controller

CPU_File="CPU_`date`".txt
echo $CPU_File
exit 0

sleep 2

ID=`ps -ef | grep $CONTROLLER| grep -v grep | awk '{print $2}'`
echo $ID

jvisualvm --openpid $ID
