#!/bin/sh

APP_HOME=$(cd "$(dirname "$0")/.."; pwd)
appname=ehl-empty-sample.jar
$APP_HOME/bin/daemon.sh stop ${appname}
