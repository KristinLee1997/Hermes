package com.aries.hermes.client.thrift.factory;

import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class TransportFactory {
    private static volatile TTransport transport;

    public static TTransport getSingleTransport() throws TTransportException {
        if (transport == null) {
            synchronized (TransportFactory.class) {
                if (transport == null) {
//                    PropertiesUtils propertiesProxy = new PropertiesUtils("gaea.properties");
//                    String host = propertiesProxy.readProperty("host");
//                    int port = Integer.parseInt(propertiesProxy.readProperty("port"));
                    String host = "127.0.0.1";
                    int port = 6010;
                    transport = new TSocket(host, port);
                    System.out.println("open transport, host:" + host + ",port:" + port);
                    transport.open();
                }
            }
        }
        return transport;
    }
}