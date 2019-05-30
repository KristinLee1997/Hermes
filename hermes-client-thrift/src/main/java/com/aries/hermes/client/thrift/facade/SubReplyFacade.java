package com.aries.hermes.client.thrift.facade;

import com.aries.hera.client.thrift.ThriftHelper;
import com.aries.hera.client.thrift.exception.ServiceNotFoundException;
import com.aries.hera.core.utils.PropertiesProxy;
import com.aries.hermes.client.thrift.vo.SubReplyVO;
import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.SubReplyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.service.SubReplyServer;
import org.apache.thrift.transport.TTransportException;

import java.util.List;

public class SubReplyFacade {
    private static final CompanyDTO companyDTO;

    static {
        PropertiesProxy propertiesProxy = new PropertiesProxy("hermes-pass.properties");
        String company = propertiesProxy.readProperty("company");
        String password = propertiesProxy.readProperty("password");
        companyDTO = new CompanyDTO(company, password, "");
    }

    public static ThriftResponse addSubReply(SubReplyVO subReplyVO) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", SubReplyServer.Client.class, client -> client.addSubReply(companyDTO, SubReplyVO.toDTO(subReplyVO)));
    }

    public static SubReplyDTO queryFirst(long replyId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", SubReplyServer.Client.class, client -> client.queryFirst(companyDTO, replyId));
    }

    public static SubReplyDTO queryById(long subReplyId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", SubReplyServer.Client.class, client -> client.queryById(companyDTO, subReplyId));
    }

    public static SubReplyDTO queryNext(long replyId, long lastReplyId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", SubReplyServer.Client.class, client -> client.queryNext(companyDTO, replyId, lastReplyId));
    }

    public static List<SubReplyDTO> queryAllByReplyId(long replyId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", SubReplyServer.Client.class, client -> client.queryAllByReplyId(companyDTO, replyId));
    }

    public static List<SubReplyDTO> batchQueryByReplyId(long replyId, int page, int pageSize) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", SubReplyServer.Client.class, client -> client.batchQueryByReplyId(companyDTO, replyId, page, pageSize));
    }

    public static ThriftResponse updateContent(long subReplyId, String content) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", SubReplyServer.Client.class, client -> client.updateContent(companyDTO, subReplyId, content));
    }

    public static ThriftResponse deleteBySubReplyId(long subReplyId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", SubReplyServer.Client.class, client -> client.deleteBySubReplyId(companyDTO, subReplyId));
    }

    public static ThriftResponse batchDeleteByReplyId(long replyId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", SubReplyServer.Client.class, client -> client.batchDeleteByReplyId(companyDTO, replyId));
    }

    public static Long getSubReplyCount(long replyId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Hermes", SubReplyServer.Client.class, client -> client.getSubReplyCount(companyDTO, replyId));
    }

}
