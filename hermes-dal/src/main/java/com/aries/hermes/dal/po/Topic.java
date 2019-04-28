package com.aries.hermes.dal.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`topic`")
public class Topic {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 帖子主题
     */
    @Column(name = "`theme`")
    private String theme;

    /**
     * 帖子内容
     */
    @Column(name = "`content`")
    private String content;

    /**
     * 主帖发起人id
     */
    @Column(name = "`gaea_id`")
    private Long gaeaId;

    /**
     * 主帖是否匿名发送
     */
    @Column(name = "`anonymous_send`")
    private Boolean anonymousSend;

    /**
     * 是否允许匿名回复
     */
    @Column(name = "`anonymous_reply`")
    private Boolean anonymousReply;

    /**
     * 帖子标签，种类
     */
    @Column(name = "`category_id`")
    private Long categoryId;

    /**
     * 帖子更新时间
     */
    @Column(name = "`update_time`")
    private Date updateTime;

    /**
     * 新建帖子时间
     */
    @Column(name = "`insert_time`")
    private Date insertTime;

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
     * 获取帖子主题
     *
     * @return theme - 帖子主题
     */
    public String getTheme() {
        return theme;
    }

    /**
     * 设置帖子主题
     *
     * @param theme 帖子主题
     */
    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    /**
     * 获取帖子内容
     *
     * @return content - 帖子内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置帖子内容
     *
     * @param content 帖子内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取主帖发起人id
     *
     * @return gaea_id - 主帖发起人id
     */
    public Long getGaeaId() {
        return gaeaId;
    }

    /**
     * 设置主帖发起人id
     *
     * @param gaeaId 主帖发起人id
     */
    public void setGaeaId(Long gaeaId) {
        this.gaeaId = gaeaId;
    }

    /**
     * 获取主帖是否匿名发送
     *
     * @return anonymous_send - 主帖是否匿名发送
     */
    public Boolean getAnonymousSend() {
        return anonymousSend;
    }

    /**
     * 设置主帖是否匿名发送
     *
     * @param anonymousSend 主帖是否匿名发送
     */
    public void setAnonymousSend(Boolean anonymousSend) {
        this.anonymousSend = anonymousSend;
    }

    /**
     * 获取是否允许匿名回复
     *
     * @return anonymous_reply - 是否允许匿名回复
     */
    public Boolean getAnonymousReply() {
        return anonymousReply;
    }

    /**
     * 设置是否允许匿名回复
     *
     * @param anonymousReply 是否允许匿名回复
     */
    public void setAnonymousReply(Boolean anonymousReply) {
        this.anonymousReply = anonymousReply;
    }

    /**
     * 获取帖子标签，种类
     *
     * @return category_id - 帖子标签，种类
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置帖子标签，种类
     *
     * @param categoryId 帖子标签，种类
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取帖子更新时间
     *
     * @return update_time - 帖子更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置帖子更新时间
     *
     * @param updateTime 帖子更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取新建帖子时间
     *
     * @return insert_time - 新建帖子时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * 设置新建帖子时间
     *
     * @param insertTime 新建帖子时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}