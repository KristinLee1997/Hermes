package com.aries.hermes.server.thrift.server;

import com.aries.hermes.idl.dto.ResponseCode;
import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.dto.TopicDTO;
import com.aries.hermes.idl.dto.TopicThriftResponse;
import com.aries.hermes.idl.service.TopicServer;
import com.aries.hermes.server.thrift.biz.CompanyVerify;
import org.apache.thrift.TException;

public class TopicServerImpl implements TopicServer.Iface {
    @Override
    public String ping() throws TException {
        return "pong,this is topic server";
    }

    @Override
    public ThriftResponse addTopic(CompanyDTO companyDTO, TopicDTO topicDto) throws TException {
        ThriftResponse response = new ThriftResponse();
        if (!CompanyVerify.judge(companyDTO)) {
            response.set
        }
        return null;
    }

    @Override
    public TopicThriftResponse selectTopics(CompanyDTO companyDTO, TopicDTO topicDto) throws TException {
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
    public ThriftResponse updateById(CompanyDTO companyDTO, TopicDTO topicDto) throws TException {
        return null;
    }
}
