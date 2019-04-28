package com.aries.hermes.server.thrift.server;

import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ReplyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.service.TopicServer;
import com.aries.hermes.server.thrift.server.util.CompanyHelper;
import org.apache.thrift.TException;

import java.util.Collections;
import java.util.List;

public class TopicServerImpl implements TopicServer.Iface {
    @Override
    public String ping() throws TException {

        return "pong,this is topic server";
    }

    public ThriftResponse xxx(CompanyDTO companyDTO) {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).invoke();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }


        return null;
    }


    public List xxxx(CompanyDTO companyDTO) {
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
}
