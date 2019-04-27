package com.aries.hermes.dal.po;

import java.util.Date;

public class Topic {
    private Long id;

    private String theme;

    private Long gaeaId;

    private Boolean anonymousSend;

    private Boolean anonymousReply;

    private Long categoryId;

    private Date updateTime;

    private Date insertTime;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public Long getGaeaId() {
        return gaeaId;
    }

    public void setGaeaId(Long gaeaId) {
        this.gaeaId = gaeaId;
    }

    public Boolean getAnonymousSend() {
        return anonymousSend;
    }

    public void setAnonymousSend(Boolean anonymousSend) {
        this.anonymousSend = anonymousSend;
    }

    public Boolean getAnonymousReply() {
        return anonymousReply;
    }

    public void setAnonymousReply(Boolean anonymousReply) {
        this.anonymousReply = anonymousReply;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}