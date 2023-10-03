#!/usr/bin/env bash

mvn clean install

docker build -f docker/Dockerfile -t translate/build:latest docker