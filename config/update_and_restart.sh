#!/bin/bash


REPO_URL="https://github.com/SaiDheerajPeketi/Nginx-Script-Deployment"  
APP_DIR="/home/user/Nginx-Script-Deployment"                       
SERVICE_NAME="springroot"                            
GRADLE_BIN="/usr/bin/gradle"                               

cd "$APP_DIR" || exit
git pull origin main  

"$GRADLE_BIN" clean build

sudo systemctl restart "$SERVICE_NAME"
