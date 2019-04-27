package com.aries.hermes.dal.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`company`")
public class Company {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司名称
     */
    @Column(name = "`company_name`")
    private String companyName;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 公司对应数据库的名字
     */
    @Column(name = "`db_name`")
    private String dbName;

    /**
     * 注册码
     */
    @Column(name = "`keyword`")
    private String keyword;

    /**
     * 注册时间
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
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名称
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取公司对应数据库的名字
     *
     * @return db_name - 公司对应数据库的名字
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * 设置公司对应数据库的名字
     *
     * @param dbName 公司对应数据库的名字
     */
    public void setDbName(String dbName) {
        this.dbName = dbName == null ? null : dbName.trim();
    }

    /**
     * 获取注册码
     *
     * @return keyword - 注册码
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 设置注册码
     *
     * @param keyword 注册码
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * 获取注册时间
     *
     * @return insert_time - 注册时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * 设置注册时间
     *
     * @param insertTime 注册时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}