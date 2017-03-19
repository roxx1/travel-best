#!/bin/bash

cp -r frontend/dist backend/src/main/resources/public
gradle -p backend build

