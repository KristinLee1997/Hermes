package com.aries.hermes.server.thrift.server;

import com.alibaba.fastjson.JSON;
import com.aries.hermes.dal.po.Topic;
import com.aries.hermes.dal.repository.TopicRepository;
import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.dto.TopicDTO;
import com.aries.hermes.idl.dto.TopicThriftResponse;
import com.aries.hermes.idl.service.TopicServer;
import com.aries.hermes.server.thrift.util.CompanyHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

import static com.aries.hermes.server.thrift.constants.HermesResponseEnum.*;

@Slf4j
public class TopicServerImpl implements TopicServer.Iface {

    @Override
    public String ping() throws TException {
        log.debug("pong, topic server");
        return "pong,this is topic server";
    }

    @Override
    public ThriftResponse addTopic(CompanyDTO companyDTO, TopicDTO topicDTO) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }
        try {
            boolean effect = TopicRepository.addTopic(companyHelper.getDatabaseName(), convert2TopicPO(topicDTO));
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("插入topic失败, company:{}, topic:{}, error:{}", JSON.toJSONString(companyDTO), JSON.toJSONString(topicDTO), e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    @Override
    public TopicThriftResponse selectTopics(CompanyDTO companyDTO, TopicDTO topicDTO) throws TException {
        return null;
    }

    @Override
    public TopicThriftResponse selectAllTopics(CompanyDTO companyDTO) throws TException {
        return null;
    }

    @Override
    public TopicThriftResponse batchQueryTopics(CompanyDTO companyDTO, int page, long pagesize) throws TException {
        return null;
    }

    @Override
    public ThriftResponse deleteById(CompanyDTO companyDTO, long id) throws TException {
        return null;
    }

    @Override
    public ThriftResponse updateById(CompanyDTO companyDTO, TopicDTO topicDTO) throws TException {
        return null;
    }

    private static Topic convert2TopicPO(TopicDTO topicDTO) {
        Topic topic = new Topic();
        topic.setTheme(topicDTO.getTheme());
        topic.setCategoryId(topicDTO.getCategoryId());
        topic.setGaeaId(topicDTO.getGaeaId());
        topic.setAnonymousSend(topicDTO.isAnonymousSend());
        topic.setAnonymousReply(topicDTO.isAnonymousReply());
        topic.setContent(topicDTO.getContent());
        return topic;
    }
}
