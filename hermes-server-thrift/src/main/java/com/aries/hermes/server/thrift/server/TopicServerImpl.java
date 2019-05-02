package com.aries.hermes.server.thrift.server;

import com.alibaba.fastjson.JSON;
import com.aries.hermes.dal.exception.BatchQueryException;
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

import java.util.ArrayList;
import java.util.List;

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
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        TopicThriftResponse response = new TopicThriftResponse();
        if (companyHelper.isError()) {
            response.setCode(companyHelper.getResponse().getCode());
            response.setMessage(companyHelper.getResponse().getMessage());
            return response;
        }
        Topic topic = convert2TopicPO(topicDTO);
        List<Topic> topicList = TopicRepository.selectBySelective(companyHelper.getDatabaseName(), topic);
        response.setCode(SUCCESS.of().getCode());
        response.setMessage(SUCCESS.of().getMessage());
        response.setTopicDTO(convert2TopicDTOList(topicList));
        return response;
    }

    @Override
    public TopicThriftResponse selectAllTopics(CompanyDTO companyDTO) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        TopicThriftResponse response = new TopicThriftResponse();
        if (companyHelper.isError()) {
            response.setCode(companyHelper.getResponse().getCode());
            response.setMessage(companyHelper.getResponse().getMessage());
            return response;
        }
        List<Topic> topicList = TopicRepository.selectAll(companyHelper.getDatabaseName());
        response.setCode(SUCCESS.of().getCode());
        response.setMessage(SUCCESS.of().getMessage());
        response.setTopicDTO(convert2TopicDTOList(topicList));
        return response;
    }

    @Override
    public TopicThriftResponse batchQueryTopics(CompanyDTO companyDTO, int page, int pagesize) {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        TopicThriftResponse response = new TopicThriftResponse();
        if (companyHelper.isError()) {
            response.setCode(companyHelper.getResponse().getCode());
            response.setMessage(companyHelper.getResponse().getMessage());
            return response;
        }
        try {
            List<Topic> topicList = TopicRepository.batchQueryTopics(companyHelper.getDatabaseName(), page, pagesize);
            response.setCode(SUCCESS.of().getCode());
            response.setMessage(SUCCESS.of().getMessage());
            response.setTopicDTO(convert2TopicDTOList(topicList));
        } catch (BatchQueryException e) {
            log.error("批量查询主帖失败，companyName:{},database:{},error:{}", companyDTO.getName(), companyHelper.getDatabaseName(), e.getMessage(), e);
            response.setCode(SYSTEM_ERROR.of().getCode());
            response.setMessage(SYSTEM_ERROR.of().getMessage());
            return response;
        }
        return response;
    }

    @Override
    public ThriftResponse deleteById(CompanyDTO companyDTO, long id) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }
        try {
            boolean effect = TopicRepository.deleteById(companyHelper.getDatabaseName(), id);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("根据id删除主帖失败，companyName:{},database:{},error:{}", companyDTO.getName(), companyHelper.getDatabaseName(), e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    @Override
    public ThriftResponse updateById(CompanyDTO companyDTO, TopicDTO topicDTO) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }
        try {
            boolean effect = TopicRepository.updateTopic(companyHelper.getDatabaseName(), convert2TopicPO(topicDTO));
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("根据id更新主帖失败，companyName:{},database:{},error:{}", companyDTO.getName(), companyHelper.getDatabaseName(), e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    @Override
    public long getTopicCount(CompanyDTO companyDTO, long categoryId) throws TException {
        return 0;
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

    private static TopicDTO convert2TopicDTO(Topic topic) {
        TopicDTO topicDTO = new TopicDTO();
        topicDTO.setId(topic.getId());
        topicDTO.setTheme(topic.getTheme());
        topicDTO.setContent(topic.getContent());
        topicDTO.setGaeaId(topic.getGaeaId());
        topicDTO.setAnonymousSend(topic.getAnonymousSend());
        topicDTO.setAnonymousReply(topic.getAnonymousReply());
        topicDTO.setUpdateTime(String.valueOf(topic.getUpdateTime()));
        topicDTO.setInsertTime(String.valueOf(topic.getInsertTime()));
        return topicDTO;
    }

    public static List<TopicDTO> convert2TopicDTOList(List<Topic> topicList) {
        List<TopicDTO> list = new ArrayList<>();
        for (Topic topic : topicList) {
            list.add(convert2TopicDTO(topic));
        }
        return list;
    }
}
