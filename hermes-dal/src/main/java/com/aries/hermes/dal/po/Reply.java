package com.aries.hermes.dal.po;

import java.util.Date;

public class Reply {
    private Long id;

    private Long topicId;

    private Long gaeaId;

    private Date insertTime;

    private Date updateTime;

    private Boolean anonymousSend;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getGaeaId() {
        return gaeaId;
    }

    public void setGaeaId(Long gaeaId) {
        this.gaeaId = gaeaId;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getAnonymousSend() {
        return anonymousSend;
    }

    public void setAnonymousSend(Boolean anonymousSend) {
        this.anonymousSend = anonymousSend;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}