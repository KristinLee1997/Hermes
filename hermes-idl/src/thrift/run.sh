#!/usr/bin/env bash
rm -rf ./gen-java

thrift -gen java service.thrift
thrift -gen java service2.thrift
thrift -gen java dto.thrift
thrift -gen java dto2.thrift

rm -rf ./../thrift/../main/java/
mv ./gen-java ./../thrift/../main/java/