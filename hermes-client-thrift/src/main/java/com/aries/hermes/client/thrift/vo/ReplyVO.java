package com.aries.hermes.client.thrift.vo;

import com.aries.hermes.idl.dto.ReplyDTO;
import com.aries.hermes.idl.dto.SubReplyDTO;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReplyVO {
    private long id;
    private long topicId;
    private long gaeaId;
    private String content;
    private String insertTime;
    private String updateTime;
    private boolean anonymousSend;
    private List<SubReplyDTO> subReplies;

    public long getId() {
        return id;
    }

    public long getTopicId() {
        return topicId;
    }

    public long getGaeaId() {
        return gaeaId;
    }

    public String getContent() {
        return content;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public boolean isAnonymousSend() {
        return anonymousSend;
    }

    public List<SubReplyDTO> getSubReplies() {
        return subReplies;
    }


    public static final class ReplyVOBuilder {
        private long topicId;
        private long gaeaId;
        private String content;
        private boolean anonymousSend;

        private ReplyVOBuilder() {
        }

        public static ReplyVOBuilder aReplyVO() {
            return new ReplyVOBuilder();
        }

        public ReplyVOBuilder topicId(long topicId) {
            this.topicId = topicId;
            return this;
        }

        public ReplyVOBuilder gaeaId(long gaeaId) {
            this.gaeaId = gaeaId;
            return this;
        }

        public ReplyVOBuilder content(String content) {
            this.content = content;
            return this;
        }

        public ReplyVOBuilder anonymousSend(boolean anonymousSend) {
            this.anonymousSend = anonymousSend;
            return this;
        }

        public ReplyVO build() {
            ReplyVO replyVO = new ReplyVO();
            replyVO.anonymousSend = this.anonymousSend;
            replyVO.topicId = this.topicId;
            replyVO.content = this.content;
            replyVO.gaeaId = this.gaeaId;
            return replyVO;
        }
    }

    public static ReplyDTO toDTO(ReplyVO replyVO) {
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.topicId = replyVO.topicId;
        replyDTO.gaeaId = replyVO.gaeaId;
        replyDTO.content = replyVO.content;
        replyDTO.anonymousSend = replyVO.anonymousSend;
        replyDTO.subReplies = replyVO.subReplies;
        return replyDTO;
    }

    public static ReplyVO buildFromDTO(ReplyDTO replyDTO) {
        ReplyVO replyVO = new ReplyVO();
        replyVO.id = replyDTO.id;
        replyVO.topicId = replyDTO.topicId;
        replyVO.gaeaId = replyDTO.gaeaId;
        replyVO.content = replyDTO.content;
        replyVO.insertTime = replyDTO.insertTime;
        replyVO.updateTime = replyDTO.updateTime;
        replyVO.anonymousSend = replyDTO.anonymousSend;
        replyVO.subReplies = replyDTO.subReplies;
        return replyVO;
    }

    public static List<ReplyVO> buildFromDTO(List<ReplyDTO> replyDTOList) {
        if (CollectionUtils.isEmpty(replyDTOList)) {
            return Collections.emptyList();
        }
        return replyDTOList.stream().map(ReplyVO::buildFromDTO).collect(Collectors.toList());
    }

}
