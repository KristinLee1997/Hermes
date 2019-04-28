package com.aries.hermes.client.thrift.utils;

import com.aries.hermes.client.thrift.factory.HermesClientFactory;
import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.dto.TopicDTO;
import com.aries.hermes.idl.service.TopicServer;
import org.apache.thrift.TException;

public class TopicUtils {
    public static ThriftResponse register(CompanyDTO companyDTO, TopicDTO topicDTO) throws TException {
        TopicServer.Client client = HermesClientFactory.getCompanyUtilsSingleClient();
        ThriftResponse response = client.addTopic(companyDTO, topicDTO);
        return response;
    }
}
