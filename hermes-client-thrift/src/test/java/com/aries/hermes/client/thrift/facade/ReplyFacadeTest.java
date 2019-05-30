package com.aries.hermes.client.thrift.facade;

import com.alibaba.fastjson.JSON;
import com.aries.hera.client.thrift.exception.ServiceNotFoundException;
import com.aries.hermes.client.thrift.exception.CallFailedException;
import com.aries.hermes.client.thrift.exception.PageSizeLimitException;
import com.aries.hermes.client.thrift.vo.ReplyVO;
import org.apache.thrift.transport.TTransportException;
import org.junit.Test;

public class ReplyFacadeTest {

    @Test
    public void addReply() throws ServiceNotFoundException, TTransportException {
        ReplyFacade.addReply(ReplyVO.ReplyVOBuilder.aReplyVO().topicId(1).content("测试内容1").gaeaId(0L).build());
    }

    @Test
    public void queryFirst() throws ServiceNotFoundException, TTransportException {
        System.out.println(ReplyFacade.queryFirst(1L));
    }

    @Test
    public void queryById() throws ServiceNotFoundException, TTransportException {
        System.out.println(ReplyFacade.queryById(194L));
    }

    @Test
    public void queryNext() throws ServiceNotFoundException, TTransportException {
        System.out.println(ReplyFacade.queryNext(1L, 1L));
    }

    @Test
    public void queryAllByTopicId() throws ServiceNotFoundException, TTransportException {
        System.out.println(ReplyFacade.queryAllByTopicId(1L));
    }

    @Test
    public void batchQueryByTopicId() throws PageSizeLimitException, CallFailedException {
        System.out.println(JSON.toJSONString(ReplyFacade.batchQueryByTopicId(1L, 1, 100)));
    }

    @Test
    public void updateContent() throws ServiceNotFoundException, TTransportException {
        System.out.println(ReplyFacade.updateContent(198L, "测试修改1"));
    }

    @Test
    public void deleteByReplyId() throws ServiceNotFoundException, TTransportException {
        System.out.println(ReplyFacade.deleteByReplyId(194L));
    }

    @Test
    public void batchDeleteByTopicId() throws ServiceNotFoundException, TTransportException {
        System.out.println(ReplyFacade.batchDeleteByTopicId(35L));

    }

    @Test
    public void getReplyCount() throws ServiceNotFoundException, TTransportException {
        System.out.println(ReplyFacade.getReplyCount(38));

    }
}
