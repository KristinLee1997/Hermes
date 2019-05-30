package com.aries.hermes.client.thrift.facade;

import com.aries.hera.client.thrift.ThriftHelper;
import com.aries.hera.client.thrift.exception.ServiceNotFoundException;
import com.aries.hera.core.utils.PropertiesProxy;
import com.aries.hermes.client.thrift.exception.CallFailedException;
import com.aries.hermes.client.thrift.exception.PageSizeLimitException;
import com.aries.hermes.client.thrift.vo.ReplyVO;
import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ReplyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.service.ReplyServer;
import org.apache.thrift.transport.TTransportException;

import java.util.Collections;
import java.util.List;

public class ReplyFacade {
    private static final CompanyDTO companyDTO;

    static {
        PropertiesProxy propertiesProxy = new PropertiesProxy("hermes-pass.properties");
        String company = propertiesProxy.readProperty("company");
        String password = propertiesProxy.readProperty("password");
        companyDTO = new CompanyDTO(company, password, "");
    }

    public static ThriftResponse addReply(ReplyVO replyVO) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", ReplyServer.Client.class, client -> client.addReply(companyDTO, ReplyVO.toDTO(replyVO)));
    }

    public static ReplyDTO queryFirst(long topicId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", ReplyServer.Client.class, client -> client.queryFirst(companyDTO, topicId));
    }

    public static ReplyDTO queryById(long replyId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", ReplyServer.Client.class, client -> client.queryById(companyDTO, replyId));
    }

    public static ReplyDTO queryNext(long topicId, long lastReplyId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", ReplyServer.Client.class, client -> client.queryNext(companyDTO, topicId, lastReplyId));
    }

    public static List<ReplyDTO> queryAllByTopicId(long topicId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", ReplyServer.Client.class, client -> client.queryAllByTopicId(companyDTO, topicId));
    }

    public static List<ReplyVO> batchQueryByTopicId(long topicId, int page, int pageSize) throws PageSizeLimitException, CallFailedException {
        if (page <= 0) {
            return Collections.emptyList();
        } else if (pageSize > 100) {
            throw new PageSizeLimitException("分页查询，最大每页100");
        }
        List<ReplyDTO> replyDTOList;
        try {
            replyDTOList = ThriftHelper.call("Hermes", ReplyServer.Client.class, client -> client.batchQueryByTopicId(companyDTO, topicId, page, pageSize));
        } catch (TTransportException e) {
            throw new CallFailedException("TTransportException", e);
        } catch (ServiceNotFoundException e) {
            throw new CallFailedException("hermes服务未找到", e);
        }
        return ReplyVO.buildFromDTO(replyDTOList);

    }

    public static ThriftResponse updateContent(long replyId, String content) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", ReplyServer.Client.class, client -> client.updateContent(companyDTO, replyId, content));
    }

    public static ThriftResponse deleteByReplyId(long replyId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", ReplyServer.Client.class, client -> client.deleteByReplyId(companyDTO, replyId));
    }

    public static ThriftResponse batchDeleteByTopicId(long topicId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", ReplyServer.Client.class, client -> client.batchDeleteByTopicId(companyDTO, topicId));
    }

    public static Long getReplyCount(long topicId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", ReplyServer.Client.class, client -> client.getReplyCount(companyDTO, topicId));
    }
}
