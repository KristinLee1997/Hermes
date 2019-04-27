package com.aries.hermes.dal.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TopicExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andThemeIsNull() {
            addCriterion("theme is null");
            return (Criteria) this;
        }

        public Criteria andThemeIsNotNull() {
            addCriterion("theme is not null");
            return (Criteria) this;
        }

        public Criteria andThemeEqualTo(String value) {
            addCriterion("theme =", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotEqualTo(String value) {
            addCriterion("theme <>", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThan(String value) {
            addCriterion("theme >", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThanOrEqualTo(String value) {
            addCriterion("theme >=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThan(String value) {
            addCriterion("theme <", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThanOrEqualTo(String value) {
            addCriterion("theme <=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLike(String value) {
            addCriterion("theme like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotLike(String value) {
            addCriterion("theme not like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeIn(List<String> values) {
            addCriterion("theme in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotIn(List<String> values) {
            addCriterion("theme not in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeBetween(String value1, String value2) {
            addCriterion("theme between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotBetween(String value1, String value2) {
            addCriterion("theme not between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andGaeaIdIsNull() {
            addCriterion("gaea_id is null");
            return (Criteria) this;
        }

        public Criteria andGaeaIdIsNotNull() {
            addCriterion("gaea_id is not null");
            return (Criteria) this;
        }

        public Criteria andGaeaIdEqualTo(Long value) {
            addCriterion("gaea_id =", value, "gaeaId");
            return (Criteria) this;
        }

        public Criteria andGaeaIdNotEqualTo(Long value) {
            addCriterion("gaea_id <>", value, "gaeaId");
            return (Criteria) this;
        }

        public Criteria andGaeaIdGreaterThan(Long value) {
            addCriterion("gaea_id >", value, "gaeaId");
            return (Criteria) this;
        }

        public Criteria andGaeaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("gaea_id >=", value, "gaeaId");
            return (Criteria) this;
        }

        public Criteria andGaeaIdLessThan(Long value) {
            addCriterion("gaea_id <", value, "gaeaId");
            return (Criteria) this;
        }

        public Criteria andGaeaIdLessThanOrEqualTo(Long value) {
            addCriterion("gaea_id <=", value, "gaeaId");
            return (Criteria) this;
        }

        public Criteria andGaeaIdIn(List<Long> values) {
            addCriterion("gaea_id in", values, "gaeaId");
            return (Criteria) this;
        }

        public Criteria andGaeaIdNotIn(List<Long> values) {
            addCriterion("gaea_id not in", values, "gaeaId");
            return (Criteria) this;
        }

        public Criteria andGaeaIdBetween(Long value1, Long value2) {
            addCriterion("gaea_id between", value1, value2, "gaeaId");
            return (Criteria) this;
        }

        public Criteria andGaeaIdNotBetween(Long value1, Long value2) {
            addCriterion("gaea_id not between", value1, value2, "gaeaId");
            return (Criteria) this;
        }

        public Criteria andAnonymousSendIsNull() {
            addCriterion("anonymous_send is null");
            return (Criteria) this;
        }

        public Criteria andAnonymousSendIsNotNull() {
            addCriterion("anonymous_send is not null");
            return (Criteria) this;
        }

        public Criteria andAnonymousSendEqualTo(Boolean value) {
            addCriterion("anonymous_send =", value, "anonymousSend");
            return (Criteria) this;
        }

        public Criteria andAnonymousSendNotEqualTo(Boolean value) {
            addCriterion("anonymous_send <>", value, "anonymousSend");
            return (Criteria) this;
        }

        public Criteria andAnonymousSendGreaterThan(Boolean value) {
            addCriterion("anonymous_send >", value, "anonymousSend");
            return (Criteria) this;
        }

        public Criteria andAnonymousSendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("anonymous_send >=", value, "anonymousSend");
            return (Criteria) this;
        }

        public Criteria andAnonymousSendLessThan(Boolean value) {
            addCriterion("anonymous_send <", value, "anonymousSend");
            return (Criteria) this;
        }

        public Criteria andAnonymousSendLessThanOrEqualTo(Boolean value) {
            addCriterion("anonymous_send <=", value, "anonymousSend");
            return (Criteria) this;
        }

        public Criteria andAnonymousSendIn(List<Boolean> values) {
            addCriterion("anonymous_send in", values, "anonymousSend");
            return (Criteria) this;
        }

        public Criteria andAnonymousSendNotIn(List<Boolean> values) {
            addCriterion("anonymous_send not in", values, "anonymousSend");
            return (Criteria) this;
        }

        public Criteria andAnonymousSendBetween(Boolean value1, Boolean value2) {
            addCriterion("anonymous_send between", value1, value2, "anonymousSend");
            return (Criteria) this;
        }

        public Criteria andAnonymousSendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("anonymous_send not between", value1, value2, "anonymousSend");
            return (Criteria) this;
        }

        public Criteria andAnonymousReplyIsNull() {
            addCriterion("anonymous_reply is null");
            return (Criteria) this;
        }

        public Criteria andAnonymousReplyIsNotNull() {
            addCriterion("anonymous_reply is not null");
            return (Criteria) this;
        }

        public Criteria andAnonymousReplyEqualTo(Boolean value) {
            addCriterion("anonymous_reply =", value, "anonymousReply");
            return (Criteria) this;
        }

        public Criteria andAnonymousReplyNotEqualTo(Boolean value) {
            addCriterion("anonymous_reply <>", value, "anonymousReply");
            return (Criteria) this;
        }

        public Criteria andAnonymousReplyGreaterThan(Boolean value) {
            addCriterion("anonymous_reply >", value, "anonymousReply");
            return (Criteria) this;
        }

        public Criteria andAnonymousReplyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("anonymous_reply >=", value, "anonymousReply");
            return (Criteria) this;
        }

        public Criteria andAnonymousReplyLessThan(Boolean value) {
            addCriterion("anonymous_reply <", value, "anonymousReply");
            return (Criteria) this;
        }

        public Criteria andAnonymousReplyLessThanOrEqualTo(Boolean value) {
            addCriterion("anonymous_reply <=", value, "anonymousReply");
            return (Criteria) this;
        }

        public Criteria andAnonymousReplyIn(List<Boolean> values) {
            addCriterion("anonymous_reply in", values, "anonymousReply");
            return (Criteria) this;
        }

        public Criteria andAnonymousReplyNotIn(List<Boolean> values) {
            addCriterion("anonymous_reply not in", values, "anonymousReply");
            return (Criteria) this;
        }

        public Criteria andAnonymousReplyBetween(Boolean value1, Boolean value2) {
            addCriterion("anonymous_reply between", value1, value2, "anonymousReply");
            return (Criteria) this;
        }

        public Criteria andAnonymousReplyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("anonymous_reply not between", value1, value2, "anonymousReply");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNull() {
            addCriterion("insert_time is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("insert_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Date value) {
            addCriterion("insert_time =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterion("insert_time <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterion("insert_time >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insert_time >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterion("insert_time <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterion("insert_time <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterion("insert_time in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterion("insert_time not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterion("insert_time between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterion("insert_time not between", value1, value2, "insertTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}