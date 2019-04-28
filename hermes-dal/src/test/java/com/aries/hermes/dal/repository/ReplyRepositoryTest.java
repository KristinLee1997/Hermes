package com.aries.hermes.dal.repository;

import com.alibaba.fastjson.JSON;
import com.aries.hermes.dal.po.Reply;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ReplyRepositoryTest {
    private String database;
    private Reply reply;

    @Parameterized.Parameters
    public static Collection getParams() {
        return Arrays.asList(new Object[][]{
                {
                        "hermes_aries_hotel",
                        new Reply() {{
                            setTopicId(1L);
                            setContent("topic 1, reply 1");
                        }}
                },
                {
                        "hermes_aries_hotel",
                        new Reply() {{
                            setTopicId(1L);
                            setContent("topic 1, reply 2");
                        }}
                },
                {
                        "hermes_aries_hotel",
                        new Reply() {{
                            setTopicId(2L);
                            setContent("topic 2, reply 1");
                        }}
                },
                {
                        "hermes_aries_hotel",
                        new Reply() {{
                            setTopicId(2L);
                            setContent("topic 2, reply 2");
                        }}
                }
        });
    }

    public ReplyRepositoryTest(String database, Reply reply) {
        this.database = database;
        this.reply = reply;
    }

    @Before
    public void addReplyTest() {
        boolean b = ReplyRepository.addReply(database, this.reply);
        System.out.println("addReplyTest:" + JSON.toJSONString(this.reply));
    }

    @Test
    public void queryFirstTest() {
        Reply result = ReplyRepository.queryFirst(database, this.reply.getTopicId());
        System.out.println("queryFirstTest:" + JSON.toJSONString(result));
    }

    @Test
    public void queryByIdTest() {
        Reply result = ReplyRepository.queryById(database, this.reply.getId());
        System.out.println("queryByIdTest:" + JSON.toJSONString(result));
    }

    @Test
    public void queryNextTest() {
        Reply result = ReplyRepository.queryNext(database, this.reply.getTopicId(), this.reply.getId());
        System.out.println("queryNextTest:" + JSON.toJSONString(result));
    }

    @Test
    public void queryAllByTopicIdTest() {
        List<Reply> results = ReplyRepository.queryAllByTopicId(database, this.reply.getTopicId());
        System.out.println("queryAllByTopicIdTest:" + JSON.toJSONString(results));
    }

    @Test
    public void batchQueryByTopicIdTest() {
        List<Reply> results = ReplyRepository.batchQueryByTopicId(database, this.reply.getTopicId(), 1, 10);
        System.out.println("batchQueryByTopicIdTest:" + JSON.toJSONString(results));
    }


    @Test
    public void updateContentTest() {
        boolean b = ReplyRepository.updateContent(database, this.reply.getId(), this.reply.getContent() + "。修改了一下");
        System.out.println("updateContentTest:" + JSON.toJSONString(this.reply));
    }

    @After
    public void delReplyByIdTest() {
        boolean b = ReplyRepository.deleteByReplyId(database, this.reply.getId());
        System.out.println("delReplyByIdTest:" + JSON.toJSONString(this.reply));
    }

    @Test
    public void batchDeleteByTopicIdTest() {
        long topicId = 0L;
        String database = "hermes_aries_hotel";

        for (int i = 0; i < 5; i++) {
            Reply reply = new Reply();
            reply.setTopicId(topicId);
            reply.setContent("用于删除, " + i);
            ReplyRepository.addReply(database, reply);
            System.out.println("batchDeleteByTopicIdTest:" + JSON.toJSONString(reply));
        }

        boolean b = ReplyRepository.batchDeleteByTopicId(database, topicId);
        System.out.println("batchDeleteByTopicIdTest:" + b);
    }
}
