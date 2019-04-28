package com.aries.hermes.server.thrift.server;

import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.SubReplyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.service.SubReplyServer;
import com.aries.hermes.server.thrift.util.CompanyHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

import java.util.Collections;
import java.util.List;

@Slf4j
public class SubReplyServerImpl implements SubReplyServer.Iface {
    @Override
    public String ping() throws TException {
        log.debug("pong, sub reply server");
        return "pong,this is sub reply server";
    }

    @Override
    public ThriftResponse addSubReply(CompanyDTO companyDTO, SubReplyDTO subReplyDTO) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }

        return null;
    }

    @Override
    public SubReplyDTO queryFirst(CompanyDTO companyDTO, long replyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return null;
        }

        return null;
    }

    @Override
    public SubReplyDTO queryById(CompanyDTO companyDTO, long subReplyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return null;
        }

        return null;
    }

    @Override
    public SubReplyDTO queryNext(CompanyDTO companyDTO, long replyId, long lastReplyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return null;
        }

        return null;
    }

    @Override
    public List<SubReplyDTO> queryAllByReplyId(CompanyDTO companyDTO, long replyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }


        return null;
    }

    @Override
    public List<SubReplyDTO> batchQueryByReplyId(CompanyDTO companyDTO, long replyId, int page, int pageSize) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }


        return null;
    }

    @Override
    public ThriftResponse updateContent(CompanyDTO companyDTO, long subReplyId, String content) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }

        return null;
    }

    @Override
    public ThriftResponse deleteBySubReplyId(CompanyDTO companyDTO, long subReplyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }


        return null;
    }

    @Override
    public ThriftResponse batchDeleteByReplyId(CompanyDTO companyDTO, long replyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }


        return null;
    }


}
