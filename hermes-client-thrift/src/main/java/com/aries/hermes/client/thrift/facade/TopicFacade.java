package com.aries.hermes.client.thrift.facade;

import com.aries.hera.client.thrift.ThriftHelper;
import com.aries.hera.client.thrift.exception.ServiceNotFoundException;
import com.aries.hera.core.utils.PropertiesProxy;
import com.aries.hermes.client.thrift.exception.CallFailedException;
import com.aries.hermes.client.thrift.exception.PageSizeLimitException;
import com.aries.hermes.client.thrift.vo.TopicVO;
import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.dto.TopicThriftResponse;
import com.aries.hermes.idl.service.TopicServer;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.thrift.transport.TTransportException;

import java.util.Collections;
import java.util.List;

public class TopicFacade {
    private static final CompanyDTO companyDTO;

    static {
        PropertiesProxy propertiesProxy = new PropertiesProxy("hermes-pass.properties");
        String company = propertiesProxy.readProperty("company");
        String password = propertiesProxy.readProperty("password");
        companyDTO = new CompanyDTO(company, password, "");
    }

    public static ThriftResponse addTopic(TopicVO topicVO) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", TopicServer.Client.class, client -> client.addTopic(companyDTO, TopicVO.toDTO(topicVO)));
    }

    public static List<TopicVO> batchQueryTopics(int page, int pageSize) throws PageSizeLimitException, CallFailedException {
        if (page <= 0) {
            return Collections.emptyList();
        } else if (pageSize > 100) {
            throw new PageSizeLimitException("分页查询，最大每页100");
        }
        TopicThriftResponse topicThriftResponse = null;
        try {
            topicThriftResponse = ThriftHelper.call("Hermes", TopicServer.Client.class, client -> client.batchQueryTopics(companyDTO, page, pageSize));
        } catch (TTransportException e) {
            throw new CallFailedException("TTransportException", e);
        } catch (ServiceNotFoundException e) {
            throw new CallFailedException("hermes服务未找到", e);
        }
        return TopicVO.buildFromDTO(topicThriftResponse.topicDTO);
    }

    /**
     * 将topicVO对象中，已被设置的变量作为条件，进行查询。(除了id。如果知道id，请根据queryById()方法进行查找)
     */
    public static TopicThriftResponse selectBySelective(TopicVO topicVO) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", TopicServer.Client.class, client -> client.selectTopics(companyDTO, TopicVO.toDTO(topicVO)));
    }


    public static TopicVO queryById(long topicId) throws CallFailedException {
        if (topicId < 0) {
            return null;
        }
        try {
            TopicThriftResponse topicThriftResponse = ThriftHelper.call("Hermes", TopicServer.Client.class, client -> client.selectById(companyDTO, topicId));
            if (topicThriftResponse == null || CollectionUtils.isEmpty(topicThriftResponse.getTopicDTO())) {
                return null;
            }
            return TopicVO.buildFromDTO(topicThriftResponse.getTopicDTO().get(0));
        } catch (TTransportException e) {
            throw new CallFailedException("TTransportException", e);
        } catch (ServiceNotFoundException e) {
            throw new CallFailedException("hermes服务未找到", e);
        }
    }

    public static TopicThriftResponse selectAllTopics() throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", TopicServer.Client.class, client -> client.selectAllTopics(companyDTO));
    }

    public static ThriftResponse deleteById(long id) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", TopicServer.Client.class, client -> client.deleteById(companyDTO, id));
    }

//    public static ThriftResponse updateById(long id) throws ServiceNotFoundException, TTransportException {
//        return ThriftHelper.call("Hermes", TopicServer.Client.class, client -> client.updateById(companyDTO, id));
//    }

    public static Long getTopicCount(long categoryId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", TopicServer.Client.class, client -> client.getTopicCount(companyDTO, categoryId));
    }
}
