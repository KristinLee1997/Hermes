package com.aries.hermes.starter;

import com.aries.hermes.server.thrift.ThriftServer;

public class Bootstrap {
    public static void main(String[] args) {
        new ThriftServer().start();
    }
}
