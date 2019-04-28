package com.aries.hermes.client.thrift.factory;

import com.aries.hermes.idl.service.TopicServer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class HermesClientFactory {
    public static TopicServer.Client getCompanyUtilsSingleClient() throws TTransportException {
        TTransport transport = TransportFactory.getSingleTransport();
        TProtocol protocol = new TBinaryProtocol(transport);
        return new TopicServer.Client(protocol);
    }
}