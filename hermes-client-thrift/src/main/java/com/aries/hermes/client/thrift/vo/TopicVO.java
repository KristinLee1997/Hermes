package com.aries.hermes.client.thrift.vo;

import com.aries.hermes.idl.dto.TopicDTO;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TopicVO {
    private long id;
    private String theme;
    private String content;
    private long gaeaId;
    private boolean anonymousSend;
    private boolean anonymousReply;
    private long categoryId;
    private String updateTime;
    private String insertTime;

    public long getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

    public String getContent() {
        return content;
    }

    public long getGaeaId() {
        return gaeaId;
    }

    public boolean isAnonymousSend() {
        return anonymousSend;
    }

    public boolean isAnonymousReply() {
        return anonymousReply;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getInsertTime() {
        return insertTime;
    }


    public static TopicDTO toDTO(TopicVO topicVO) {
        TopicDTO topicDTO = new TopicDTO();
        topicDTO.anonymousReply = topicVO.anonymousReply;
        topicDTO.theme = topicVO.theme;
        topicDTO.anonymousSend = topicVO.anonymousSend;
        topicDTO.categoryId = topicVO.categoryId;
        topicDTO.content = topicVO.content;
        topicDTO.gaeaId = topicVO.gaeaId;
        return topicDTO;
    }

    public static TopicVO buildFromDTO(TopicDTO topicDTO) {
        TopicVO topicVO = new TopicVO();
        topicVO.id = topicDTO.id;
        topicVO.theme = topicDTO.theme;
        topicVO.content = topicDTO.content;
        topicVO.gaeaId = topicDTO.gaeaId;
        topicVO.anonymousSend = topicDTO.anonymousSend;
        topicVO.anonymousReply = topicDTO.anonymousReply;
        topicVO.categoryId = topicDTO.categoryId;
        topicVO.updateTime = topicDTO.updateTime;
        topicVO.insertTime = topicDTO.insertTime;
        return topicVO;
    }


    public static List<TopicVO> buildFromDTO(List<TopicDTO> topicDTOList) {
        if (CollectionUtils.isEmpty(topicDTOList)) {
            return Collections.emptyList();
        }

        return topicDTOList.stream().map(TopicVO::buildFromDTO).collect(Collectors.toList());
    }

    public static final class TopicVOBuilder {
        private String theme; // required
        private String content; // required
        private long gaeaId; // required
        private boolean anonymousSend; // required
        private boolean anonymousReply; // required
        private long categoryId; // required

        private TopicVOBuilder() {
        }

        public static TopicVOBuilder aTopicVO() {
            return new TopicVOBuilder();
        }

        public TopicVOBuilder theme(String theme) {
            this.theme = theme;
            return this;
        }

        public TopicVOBuilder content(String content) {
            this.content = content;
            return this;
        }

        public TopicVOBuilder gaeaId(long gaeaId) {
            this.gaeaId = gaeaId;
            return this;
        }

        public TopicVOBuilder anonymousSend(boolean anonymousSend) {
            this.anonymousSend = anonymousSend;
            return this;
        }

        public TopicVOBuilder anonymousReply(boolean anonymousReply) {
            this.anonymousReply = anonymousReply;
            return this;
        }

        public TopicVOBuilder categoryId(long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public TopicVO build() {
            TopicVO topicVO = new TopicVO();
            topicVO.anonymousReply = this.anonymousReply;
            topicVO.theme = this.theme;
            topicVO.anonymousSend = this.anonymousSend;
            topicVO.categoryId = this.categoryId;
            topicVO.content = this.content;
            topicVO.gaeaId = this.gaeaId;
            return topicVO;
        }
    }
}
