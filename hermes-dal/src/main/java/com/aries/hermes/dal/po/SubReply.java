package com.aries.hermes.dal.po;

import java.util.Date;

public class SubReply {
    private Long id;

    private Long replyId;

    private Long senderGaeaId;

    private Long receiverGaeaId;

    private Date insertTime;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getSenderGaeaId() {
        return senderGaeaId;
    }

    public void setSenderGaeaId(Long senderGaeaId) {
        this.senderGaeaId = senderGaeaId;
    }

    public Long getReceiverGaeaId() {
        return receiverGaeaId;
    }

    public void setReceiverGaeaId(Long receiverGaeaId) {
        this.receiverGaeaId = receiverGaeaId;
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