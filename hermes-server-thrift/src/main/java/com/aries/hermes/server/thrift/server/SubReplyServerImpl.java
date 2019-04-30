package com.aries.hermes.server.thrift.server;

import com.aries.hermes.dal.po.SubReply;
import com.aries.hermes.dal.repository.SubReplyRepository;
import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.SubReplyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.service.SubReplyServer;
import com.aries.hermes.server.thrift.util.CompanyHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.thrift.TException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.aries.hermes.server.thrift.constants.HermesResponseEnum.*;

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

        try {
            boolean effect = SubReplyRepository.addSubReply(companyHelper.getDatabaseName(), convert2SubReply(subReplyDTO));
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("addSubReply error:{}", e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    @Override
    public SubReplyDTO queryFirst(CompanyDTO companyDTO, long replyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return null;
        }

        try {
            SubReply subReply = SubReplyRepository.queryFirst(companyHelper.getDatabaseName(), replyId);
            return convert2SubReplyDTO(subReply);
        } catch (Exception e) {
            log.error("queryFirst error:{}", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public SubReplyDTO queryById(CompanyDTO companyDTO, long subReplyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return null;
        }

        try {
            SubReply subReply = SubReplyRepository.queryById(companyHelper.getDatabaseName(), subReplyId);
            return convert2SubReplyDTO(subReply);
        } catch (Exception e) {
            log.error("queryById error:{}", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public SubReplyDTO queryNext(CompanyDTO companyDTO, long replyId, long lastReplyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return null;
        }

        try {
            SubReply subReply = SubReplyRepository.queryNext(companyHelper.getDatabaseName(), replyId, lastReplyId);
            return convert2SubReplyDTO(subReply);
        } catch (Exception e) {
            log.error("queryNext error:{}", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<SubReplyDTO> queryAllByReplyId(CompanyDTO companyDTO, long replyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }

        try {
            List<SubReply> subReplies = SubReplyRepository.queryAllByReplyId(companyHelper.getDatabaseName(), replyId);
            return convert2SubReplyDTO(subReplies);
        } catch (Exception e) {
            log.error("queryAllByReplyId error:{}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<SubReplyDTO> batchQueryByReplyId(CompanyDTO companyDTO, long replyId, int page, int pageSize) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }

        try {
            List<SubReply> subReplies = SubReplyRepository.batchQueryByReplyId(companyHelper.getDatabaseName(), replyId, page, pageSize);
            return convert2SubReplyDTO(subReplies);
        } catch (Exception e) {
            log.error("batchQueryByReplyId error:{}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public ThriftResponse updateContent(CompanyDTO companyDTO, long subReplyId, String content) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }

        try {
            boolean effect = SubReplyRepository.updateContent(companyHelper.getDatabaseName(), subReplyId, content);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("updateContent error:{}", e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    @Override
    public ThriftResponse deleteBySubReplyId(CompanyDTO companyDTO, long subReplyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }

        try {
            boolean effect = SubReplyRepository.deleteBySubReplyId(companyHelper.getDatabaseName(), subReplyId);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("deleteBySubReplyId error:{}", e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    @Override
    public ThriftResponse batchDeleteByReplyId(CompanyDTO companyDTO, long replyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }

        try {
            boolean effect = SubReplyRepository.batchDeleteByReplyId(companyHelper.getDatabaseName(), replyId);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("batchDeleteByReplyId error:{}", e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    private static SubReplyDTO convert2SubReplyDTO(SubReply subReply) {
        if (subReply == null) {
            return null;
        }
        SubReplyDTO subReplyDTO = new SubReplyDTO();
        subReplyDTO.setId(subReply.getId());
        subReplyDTO.setReplyId(subReply.getReplyId());
        subReplyDTO.setSenderGaeaId(subReply.getSenderGaeaId());
        subReplyDTO.setReceiverGaeaId(subReply.getReceiverGaeaId());
        subReplyDTO.setContent(subReply.getContent());
        subReplyDTO.setInsertTime(subReply.getInsertTime().toString());
        return subReplyDTO;
    }

    private static List<SubReplyDTO> convert2SubReplyDTO(List<SubReply> subReplies) {
        if (CollectionUtils.isEmpty(subReplies)) {
            return Collections.emptyList();
        }

        return subReplies.stream().map(SubReplyServerImpl::convert2SubReplyDTO).collect(Collectors.toList());
    }

    private static SubReply convert2SubReply(SubReplyDTO subReplyDTO) {
        if (subReplyDTO == null) {
            return null;
        }

        SubReply subReply = new SubReply();
        subReply.setReplyId(subReplyDTO.getReplyId());
        subReply.setSenderGaeaId(subReplyDTO.getSenderGaeaId());
        subReply.setReceiverGaeaId(subReplyDTO.getReceiverGaeaId());
        subReply.setContent(subReplyDTO.getContent());
        return subReply;
    }
}
