package com.aries.hermes.server.thrift.impl;

import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.dto.TopicDTO;
import com.aries.hermes.idl.dto.TopicThriftResponse;
import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TopicServerTest {
    private CompanyDTO companyDTO;
    private TopicDTO topicDTO;
    private long id;
    private TopicServerImpl server = new TopicServerImpl();

    public TopicServerTest(CompanyDTO companyDTO, long id, TopicDTO topicDTO) {
        this.companyDTO = companyDTO;
        this.id = id;
        this.topicDTO = topicDTO;
    }

    @Parameterized.Parameters
    public static Collection getParams() {
        return Arrays.asList(new Object[][]{
                {
                        new CompanyDTO() {{
                            setName("aries_edu");
                            setPassword("123123");
                        }},
                        1L,
                        new TopicDTO() {{
                            setTheme("怎样学习Java");
                            setContent("多打代码");
                            setAnonymousReply(true);
                            setAnonymousSend(true);
                            setGaeaId(115203L);
                        }}
                },
                {
                        new CompanyDTO() {{
                            setName("aries_edu");
                            setPassword("123123");
                        }},
                        1L,
                        new TopicDTO() {{
                            setTheme("怎样学习Python");
                            setContent("多打代码");
                            setAnonymousReply(true);
                            setAnonymousSend(true);
                            setGaeaId(115203L);
                        }}
                },
                {
                        new CompanyDTO() {{
                            setName("aries_edu");
                            setPassword("123123");
                        }},
                        1L,
                        new TopicDTO() {{
                            setTheme("怎样学习C");
                            setContent("多打代码");
                            setAnonymousReply(true);
                            setAnonymousSend(true);
                            setGaeaId(115203L);
                        }}
                },
                {
                        new CompanyDTO() {{
                            setName("aries_edu");
                            setPassword("123123");
                        }},
                        1L,
                        new TopicDTO() {{
                            setTheme("怎样学习C++");
                            setContent("多打代码");
                            setAnonymousReply(true);
                            setAnonymousSend(true);
                            setGaeaId(115203L);
                        }}
                }
        });
    }


    @Test
    public void addTopicTest() throws TException {
        ThriftResponse response = server.addTopic(companyDTO, topicDTO);
        System.out.println(response.getMessage());
    }

    @Test
    public void selectTopicsTest() throws TException {
        TopicThriftResponse response = server.selectTopics(companyDTO, topicDTO);
        response.getTopicDTO().forEach(System.out::println);
        System.out.println(response.getMessage());
    }

    @Test
    public void selectAllTopicsTest() throws TException {
        TopicThriftResponse response = server.selectAllTopics(companyDTO);
        response.getTopicDTO().forEach(System.out::println);
        System.out.println(response.getMessage());
    }

    @Test
    public void batchQueryTopicsTest() {
        TopicThriftResponse response = server.batchQueryTopics(companyDTO, 1, 2);
        response.getTopicDTO().forEach(System.out::println);
        System.out.println(response.getMessage());
    }

    @Test
    public void deleteByIdTest() throws TException {
        ThriftResponse response = server.deleteById(companyDTO, 6L);
        System.out.println(response.getMessage());
    }

    @Test
    public void updateByIdTest() throws TException {
        ThriftResponse response = server.updateById(companyDTO, id, topicDTO);
        System.out.println(response.getMessage());
    }

    @Test
    public void selectByIdTest() throws TException {
        TopicThriftResponse response = server.selectById(companyDTO, 2);
        System.out.println(response.getTopicDTO().get(0).getTheme());
        System.out.println(response.getMessage());
    }
}
