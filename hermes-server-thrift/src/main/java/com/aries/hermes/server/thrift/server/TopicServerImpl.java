package com.aries.hermes.server.thrift.server;

import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ReplyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.dto.TopicDTO;
import com.aries.hermes.idl.dto.TopicThriftResponse;
import com.aries.hermes.idl.service.TopicServer;
import com.aries.hermes.server.thrift.util.CompanyHelper;
import com.aries.hermes.server.thrift.biz.CompanyVerify;
import com.aries.hermes.server.thrift.biz.TopicBiz;
import com.aries.hermes.server.thrift.constants.HermesResponseEnum;
import org.apache.thrift.TException;

import java.util.Collections;
import java.util.List;

public class TopicServerImpl implements TopicServer.Iface {

    public static TopicBiz topicBiz = new TopicBiz();

    @Override
    public String ping() throws TException {

        return "pong,this is topic server";
    }

    public ThriftResponse xx(CompanyDTO companyDTO) {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).invoke();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }


        return null;
    }


    public List xxx(CompanyDTO companyDTO) {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).invoke();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }


        return null;
    }

    public ReplyDTO xxxx(CompanyDTO companyDTO) {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).invoke();
        if (companyHelper.isError()) {
            return null;
        }


        return null;
    }

    @Override
    public ThriftResponse addTopic(CompanyDTO companyDTO, TopicDTO topicDto) throws TException {
        if (!CompanyVerify.judgeParam(companyDTO)) {
            return HermesResponseEnum.PARAM_NULL.of();
        }
        if (CompanyVerify.judgePermission(companyDTO) != null) {
            return HermesResponseEnum.PERMISSION_FAIL.of();
        }
        return HermesResponseEnum.SUCCESS.of();
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
