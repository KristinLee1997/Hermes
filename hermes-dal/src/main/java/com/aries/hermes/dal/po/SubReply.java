package com.aries.hermes.dal.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`sub_reply`")
public class SubReply {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 二级贴id
     */
    @Column(name = "`reply_id`")
    private Long replyId;

    /**
     * 发送人
     */
    @Column(name = "`sender_gaea_id`")
    private Long senderGaeaId;

    /**
     * 接收人
     */
    @Column(name = "`receiver_gaea_id`")
    private Long receiverGaeaId;

    @Column(name = "`insert_time`")
    private Date insertTime;

    /**
     * 内容
     */
    @Column(name = "`content`")
    private String content;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取二级贴id
     *
     * @return reply_id - 二级贴id
     */
    public Long getReplyId() {
        return replyId;
    }

    /**
     * 设置二级贴id
     *
     * @param replyId 二级贴id
     */
    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    /**
     * 获取发送人
     *
     * @return sender_gaea_id - 发送人
     */
    public Long getSenderGaeaId() {
        return senderGaeaId;
    }

    /**
     * 设置发送人
     *
     * @param senderGaeaId 发送人
     */
    public void setSenderGaeaId(Long senderGaeaId) {
        this.senderGaeaId = senderGaeaId;
    }

    /**
     * 获取接收人
     *
     * @return receiver_gaea_id - 接收人
     */
    public Long getReceiverGaeaId() {
        return receiverGaeaId;
    }

    /**
     * 设置接收人
     *
     * @param receiverGaeaId 接收人
     */
    public void setReceiverGaeaId(Long receiverGaeaId) {
        this.receiverGaeaId = receiverGaeaId;
    }

    /**
     * @return insert_time
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}