#!/usr/bin/env bash
# build java maven
mvn clean package -Dmaven.test.skip=true
# tg-system
PROJECT_NAME=tg-system
TAG=registry.cn-shanghai.aliyuncs.com/tg_system/$PROJECT_NAME
# docker build
# docker stop $PROJECT_NAME
# docker rm $PROJECT_NAME
# docker rmi $TAG:latest
docker build -t $TAG:latest .
# 上传最新的镜像
if test "$1" != ""; then
  docker push $TAG:latest
  docker tag $TAG:latest $TAG:$1
  docker push $TAG:$1
fi
