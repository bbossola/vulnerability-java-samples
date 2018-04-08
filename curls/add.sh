#!/bin/sh
set -x
curl -i -X POST -d '{"name":"melon","description":"Real melon from Italy", "data":["java.util.HashMap",{"cost":2,"color":"yellow"}]}' http://localhost:8888/products; echo
