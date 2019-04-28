package com.aries.hermes.dal.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`reply`")
public class Reply {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 一级贴id
     */
    @Column(name = "`topic_id`")
    private Long topicId;

    /**
     * 账号id
     */
    @Column(name = "`gaea_id`")
    private Long gaeaId;

    /**
     * 内容
     */
    @Column(name = "`content`")
    private String content;

    @Column(name = "`insert_time`")
    private Date insertTime;

    @Column(name = "`update_time`")
    private Date updateTime;

    /**
     * 是否匿名回答。默认不匿名。false不匿名。true匿名。
     */
    @Column(name = "`anonymous_send`")
    private Boolean anonymousSend;

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
     * 获取一级贴id
     *
     * @return topic_id - 一级贴id
     */
    public Long getTopicId() {
        return topicId;
    }

    /**
     * 设置一级贴id
     *
     * @param topicId 一级贴id
     */
    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    /**
     * 获取账号id
     *
     * @return gaea_id - 账号id
     */
    public Long getGaeaId() {
        return gaeaId;
    }

    /**
     * 设置账号id
     *
     * @param gaeaId 账号id
     */
    public void setGaeaId(Long gaeaId) {
        this.gaeaId = gaeaId;
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
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否匿名回答。默认不匿名。false不匿名。true匿名。
     *
     * @return anonymous_send - 是否匿名回答。默认不匿名。false不匿名。true匿名。
     */
    public Boolean getAnonymousSend() {
        return anonymousSend;
    }

    /**
     * 设置是否匿名回答。默认不匿名。false不匿名。true匿名。
     *
     * @param anonymousSend 是否匿名回答。默认不匿名。false不匿名。true匿名。
     */
    public void setAnonymousSend(Boolean anonymousSend) {
        this.anonymousSend = anonymousSend;
    }
}