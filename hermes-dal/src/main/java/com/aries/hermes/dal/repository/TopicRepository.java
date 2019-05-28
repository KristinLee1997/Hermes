package com.aries.hermes.dal.repository;

import com.aries.hermes.dal.exception.BatchQueryException;
import com.aries.hermes.dal.mapper.TopicMapper;
import com.aries.hermes.dal.po.Topic;
import com.aries.hermes.dal.util.SqlSessionUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

public class TopicRepository {
    /**
     * 新增主帖
     *
     * @param database
     * @param topic
     * @return
     */
    public static boolean addTopic(String database, Topic topic) {
        try (SqlSession sqlSession = SqlSessionUtil.openSession(database)) {
            TopicMapper topicMapper = sqlSession.getMapper(TopicMapper.class);
            int i = topicMapper.insertSelective(topic);
            return i > 0;
        }
    }

    /**
     * 根据条件查询主帖
     *
     * @param database
     * @param topic
     * @return
     */
    public static List<Topic> selectBySelective(String database, Topic topic) {
        try (SqlSession sqlSession = SqlSessionUtil.openSession(database)) {
            TopicMapper topicMapper = sqlSession.getMapper(TopicMapper.class);
            Example example = new Example(Topic.class);
            example.createCriteria().andEqualTo(topic);
            example.orderBy("updateTime").desc();
            List<Topic> topicList = topicMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(topicList)) {
                return Collections.emptyList();
            }
            return topicList;
        }
    }

    /**
     * 查询所有topic
     *
     * @param database
     * @return
     */
    public static List<Topic> selectAll(String database) {
        try (SqlSession sqlSession = SqlSessionUtil.openSession(database)) {
            TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
            List<Topic> topicList = mapper.selectAll();
            if (CollectionUtils.isEmpty(topicList)) {
                return Collections.emptyList();
            }
            return topicList;
        }
    }

    /**
     * 批量查询主帖
     *
     * @param database
     * @param page
     * @param pageSize
     * @return
     * @throws BatchQueryException
     */
    public static List<Topic> batchQueryTopics(String database, int page, int pageSize) throws BatchQueryException {
        if (page < 1 || pageSize > 100) {
            String errorTemplate = "批量查询失败. page需要大于1, 实际:%d. pageSize需要小于等于100, 实际:%d";
            throw new BatchQueryException(String.format(errorTemplate, page, pageSize));
        }
        try (SqlSession sqlSession = SqlSessionUtil.openSession(database)) {
            TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
            Example example = new Example(Topic.class);
            example.orderBy("updateTime").desc();
            // 计算offset和limit
            int offset = (page - 1) * pageSize;
            int limit = pageSize;
            List<Topic> topicList = mapper.selectByExampleAndRowBounds(example, new RowBounds(offset, limit));
            if (CollectionUtils.isEmpty(topicList)) {
                return Collections.emptyList();
            }
            return topicList;
        }
    }

    /**
     * 根据主帖id删除主帖
     *
     * @param database
     * @param id
     * @return
     */
    public static boolean deleteById(String database, Long id) {
        try (SqlSession sqlSession = SqlSessionUtil.openSession(database)) {
            TopicMapper mapper = sqlSession.getMapper(TopicMapper.class);
            int i = mapper.deleteByPrimaryKey(id);
            return i > 0;
        }
    }

    /**
     * 根据主键更新主帖字段
     *
     * @param database
     * @param topic
     * @return
     */
    public static boolean updateTopic(String database, long id, Topic topic) {
        try (SqlSession sqlsession = SqlSessionUtil.openSession(database)) {
            TopicMapper mapper = sqlsession.getMapper(TopicMapper.class);
            topic.setId(id);
            int i = mapper.updateByPrimaryKeySelective(topic);
            return i > 0;
        }
    }

    /**
     * 根据主键查询主帖
     *
     * @param database
     * @param id
     * @return
     */
    public static Topic selectById(String database, Long id) {
        try (SqlSession sqlsession = SqlSessionUtil.openSession(database)) {
            TopicMapper mapper = sqlsession.getMapper(TopicMapper.class);
            return mapper.selectByPrimaryKey(id);
        }
    }

    public static int getTopicCount(String database, long categoryId) {
        try (SqlSession sqlsession = SqlSessionUtil.openSession(database)) {
            TopicMapper mapper = sqlsession.getMapper(TopicMapper.class);
            Example example = new Example(Topic.class);
            example.createCriteria().andEqualTo("categoryId", categoryId);
            return mapper.selectCountByExample(example);
        }
    }
}
