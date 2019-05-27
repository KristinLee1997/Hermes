package com.aries.hermes.client.thrift;

import com.alibaba.fastjson.JSON;
import com.aries.hermes.client.thrift.exception.CallFailedException;
import com.aries.hermes.client.thrift.facade.TopicFacade;
import org.junit.Test;


public class AppTest {
    @Test
    public void addTopic() throws CallFailedException {
        System.out.println(JSON.toJSONString(TopicFacade.queryById(1)));
    }
}
