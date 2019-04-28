package com.aries.hermes.server.thrift.server;

import com.aries.hermes.idl.service.TopicServer;
import org.apache.thrift.TException;

public class TopicServerImpl implements TopicServer.Iface {
    @Override
    public String ping() throws TException {
        return "pong,this is topic server";
    }
}
