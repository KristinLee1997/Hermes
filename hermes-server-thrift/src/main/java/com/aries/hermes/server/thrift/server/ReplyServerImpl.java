package com.aries.hermes.server.thrift.server;

import com.alibaba.fastjson.JSON;
import com.aries.hermes.dal.po.Reply;
import com.aries.hermes.dal.repository.ReplyRepository;
import com.aries.hermes.idl.dto.CompanyDTO;
import com.aries.hermes.idl.dto.ReplyDTO;
import com.aries.hermes.idl.dto.ThriftResponse;
import com.aries.hermes.idl.service.ReplyServer;
import com.aries.hermes.server.thrift.util.CompanyHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.thrift.TException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.aries.hermes.server.thrift.constants.HermesResponseEnum.*;

@Slf4j
public class ReplyServerImpl implements ReplyServer.Iface {
    @Override
    public String ping() throws TException {
        log.debug("pong, reply server");
        return "pong,this is reply server";
    }

    @Override
    public ThriftResponse addReply(CompanyDTO companyDTO, ReplyDTO replyDTO) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            log.warn("addReply 没有权限,companyDTO:{}, replyDTO:{}", JSON.toJSONString(companyDTO), JSON.toJSONString(replyDTO));
            return companyHelper.getResponse();
        }

        try {
            boolean effect = ReplyRepository.addReply(companyHelper.getDatabaseName(), convert2Reply(replyDTO));
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("addReply error:{}", e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    @Override
    public ReplyDTO queryFirst(CompanyDTO companyDTO, long topicId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            log.warn("queryFirst 没有权限,companyDTO:{}, topicId:{}", JSON.toJSONString(companyDTO), topicId);
            return null;
        }
        try {
            Reply reply = ReplyRepository.queryFirst(companyHelper.getDatabaseName(), topicId);
            return convert2ReplyDTO(reply);
        } catch (Exception e) {
            log.error("queryFirst error:{}", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public ReplyDTO queryById(CompanyDTO companyDTO, long replyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            log.warn("queryById 没有权限,companyDTO:{}, replyId:{}", JSON.toJSONString(companyDTO), replyId);
            return null;
        }

        try {
            Reply reply = ReplyRepository.queryById(companyHelper.getDatabaseName(), replyId);
            return convert2ReplyDTO(reply);
        } catch (Exception e) {
            log.error("queryById error:{}", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public ReplyDTO queryNext(CompanyDTO companyDTO, long topicId, long lastReplyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            log.warn("queryNext 没有权限,companyDTO:{}, topicId:{}, lastReplyId:{}", JSON.toJSONString(companyDTO), topicId, lastReplyId);
            return null;
        }

        try {
            Reply reply = ReplyRepository.queryNext(companyHelper.getDatabaseName(), topicId, lastReplyId);
            return convert2ReplyDTO(reply);
        } catch (Exception e) {
            log.error("queryNext error:{}", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public List<ReplyDTO> queryAllByTopicId(CompanyDTO companyDTO, long topicId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }

        try {
            List<Reply> replies = ReplyRepository.queryAllByTopicId(companyHelper.getDatabaseName(), topicId);
            return convert2ReplyDTO(replies);
        } catch (Exception e) {
            log.error("queryAllByTopicId error:{}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<ReplyDTO> batchQueryByTopicId(CompanyDTO companyDTO, long topicId, int page, int pageSize) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }

        try {
            List<Reply> replies = ReplyRepository.batchQueryByTopicId(companyHelper.getDatabaseName(), topicId, page, pageSize);
            return convert2ReplyDTO(replies);
        } catch (Exception e) {
            log.error("batchQueryByTopicId error:{}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public ThriftResponse updateContent(CompanyDTO companyDTO, long replyId, String content) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            log.warn("updateContent 没有权限,companyDTO:{}, replyId:{}, content:{}", JSON.toJSONString(companyDTO), replyId, content);
            return companyHelper.getResponse();
        }

        try {
            boolean effect = ReplyRepository.updateContent(companyHelper.getDatabaseName(), replyId, content);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("updateContent error:{}", e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    @Override
    public ThriftResponse deleteByReplyId(CompanyDTO companyDTO, long replyId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            log.warn("deleteByReplyId 没有权限,companyDTO:{}, replyId:{}", JSON.toJSONString(companyDTO), replyId);
            return companyHelper.getResponse();
        }

        try {
            boolean effect = ReplyRepository.deleteByReplyId(companyHelper.getDatabaseName(), replyId);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("deleteByReplyId error:{}", e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    @Override
    public ThriftResponse batchDeleteByTopicId(CompanyDTO companyDTO, long topicId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyDTO).check();
        if (companyHelper.isError()) {
            log.warn("batchDeleteByTopicId 没有权限,companyDTO:{}, topicId:{}", JSON.toJSONString(companyDTO), topicId);
            return companyHelper.getResponse();
        }

        try {
            boolean effect = ReplyRepository.batchDeleteByTopicId(companyHelper.getDatabaseName(), topicId);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            log.error("batchDeleteByTopicId error:{}", e.getMessage(), e);
            return SYSTEM_ERROR.of();
        }
    }

    private static ReplyDTO convert2ReplyDTO(Reply reply) {
        if (reply == null) {
            return null;
        }
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setId(reply.getId());
        replyDTO.setTopicId(reply.getTopicId());
        replyDTO.setGaeaId(reply.getGaeaId());
        replyDTO.setContent(reply.getContent());
        replyDTO.setInsertTime(reply.getInsertTime().toString());
        replyDTO.setUpdateTime(reply.getUpdateTime().toString());
        replyDTO.setAnonymousSend(reply.getAnonymousSend());
        return replyDTO;
    }

    private static List<ReplyDTO> convert2ReplyDTO(List<Reply> replies) {
        if (CollectionUtils.isEmpty(replies)) {
            return Collections.emptyList();
        }

        return replies.stream().map(ReplyServerImpl::convert2ReplyDTO).collect(Collectors.toList());
    }

    private static Reply convert2Reply(ReplyDTO replyDTO) {
        if (replyDTO == null) {
            return null;
        }

        Reply reply = new Reply();
        reply.setTopicId(replyDTO.getTopicId());
        reply.setGaeaId(replyDTO.getGaeaId());
        reply.setContent(replyDTO.getContent());
        reply.setAnonymousSend(replyDTO.isAnonymousSend());
        return reply;
    }
}
