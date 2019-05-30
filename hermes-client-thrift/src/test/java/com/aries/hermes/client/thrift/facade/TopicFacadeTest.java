package com.aries.hermes.client.thrift.facade;

import com.alibaba.fastjson.JSON;
import com.aries.hermes.client.thrift.exception.CallFailedException;
import com.aries.hermes.client.thrift.exception.PageSizeLimitException;
import com.aries.hermes.client.thrift.vo.TopicVO;
import com.aries.hermes.idl.dto.TopicThriftResponse;
import org.apache.thrift.transport.TTransportException;
import org.junit.Test;

public class TopicFacadeTest {
    @Test
    public void queryById() throws CallFailedException {
        System.out.println(JSON.toJSONString(TopicFacade.queryById(1)));
    }

    @Test
    public void addTopic() throws TTransportException {
        TopicFacade.addTopic(TopicVO.TopicVOBuilder.aTopicVO().theme("主贴122").build());
    }

    @Test
    public void batchQueryTopics() throws TTransportException, CallFailedException, PageSizeLimitException {
        System.out.println(JSON.toJSONString(TopicFacade.batchQueryTopics(1, 10)));
    }

    @Test
    public void selectBySelective() throws TTransportException {
        TopicThriftResponse resp = TopicFacade.selectBySelective(TopicVO.TopicVOBuilder.aTopicVO().theme("主贴122").build());
        System.out.println(JSON.toJSONString(resp.topicDTO));
    }

    @Test
    public void selectAllTopics() throws TTransportException {
        TopicThriftResponse resp = TopicFacade.selectAllTopics();

        System.out.println(JSON.toJSONString(resp.topicDTO));
    }

    @Test
    public void deleteById() throws TTransportException {
        TopicFacade.deleteById(41L);
    }

    @Test
    public void getTopicCount() throws TTransportException {
        System.out.println(TopicFacade.getTopicCount(0));
    }

}
