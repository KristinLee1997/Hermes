package com.aries.hermes.dal.repository;

import com.aries.hermes.dal.mapper.TopicMapper;
import com.aries.hermes.dal.po.Topic;
import com.aries.hermes.dal.po.TopicExample;
import com.aries.hermes.dal.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class TopicRepository {
    public boolean addTopic(String companyName, Topic topic) {
        try (SqlSession sqlSession = SqlSessionUtil.openSession(companyName)) {
            TopicMapper topicMapper = sqlSession.getMapper(TopicMapper.class);
            int i = topicMapper.insertSelective(topic);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public List<Topic> selectBySelective(String companyName, Topic topic) {
        try (SqlSession sqlSession = SqlSessionUtil.openSession(companyName)) {
            TopicMapper topicMapper = sqlSession.getMapper(TopicMapper.class);
            TopicExample example = new TopicExample();
            TopicExample.Criteria criteria = example.createCriteria();
            if (topic.getTheme() != null) {
                criteria.andThemeEqualTo(topic.getTheme());
            }
            if (topic.getCategoryId() != null) {
                criteria.andCategoryIdEqualTo(topic.getCategoryId());
            }
            if (topic.getContent() != null) {
                criteria.andContentEqualTo(topic.getContent());
            }
            if (topic.getGaeaId() != null) {
                criteria.andGaeaIdEqualTo(topic.getGaeaId());
            }
            if (topic.getAnonymousSend() != null) {
                criteria.andAnonymousSendEqualTo(topic.getAnonymousSend());
            }
            if (topic.getAnonymousReply() != null) {
                criteria.andAnonymousReplyEqualTo(topic.getAnonymousReply());
            }
            if (topic.getUpdateTime() != null) {
                example.setOrderByClause("update_time desc");
            }
            List<Topic> topicList = topicMapper.selectByExample(example);
            if (topicList == null || topicList.size() == 0) {
                return new ArrayList<>();
            }
            return topicList;
        }
    }
}
