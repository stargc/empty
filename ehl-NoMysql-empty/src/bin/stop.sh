#!/bin/sh

APP_HOME=$(cd "$(dirname "$0")/.."; pwd)
appname=grid_management.jar
$APP_HOME/bin/daemon.sh stop ${appname}
