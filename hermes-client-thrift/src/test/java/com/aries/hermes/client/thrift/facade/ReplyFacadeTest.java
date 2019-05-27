package com.aries.hermes.client.thrift.facade;

import org.apache.thrift.transport.TTransportException;
import org.junit.Test;

public class ReplyFacadeTest {
    @Test
    public void countTest() throws TTransportException {
        System.out.println(ReplyFacade.getReplyCount(38));
    }
}
