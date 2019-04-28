package com.aries.hermes.dal.repository;

import com.aries.hermes.dal.mapper.ReplyMapper;
import com.aries.hermes.dal.po.Reply;
import com.aries.hermes.dal.util.SqlSessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Slf4j
public class ReplyRepository {

    public static boolean addReply(String database, Reply reply) {
        reply.setId(null);
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);
            int effect = replyMapper.insertSelective(reply);
            return effect > 0;
        }
    }

    public static Reply queryFirst(String database, long topicId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);

            Example example = new Example(Reply.class);
            example.createCriteria().andEqualTo("topicId", topicId);
            example.orderBy("id").asc();

            List<Reply> replies = replyMapper.selectByExampleAndRowBounds(example, new RowBounds(0, 1));

            return CollectionUtils.isEmpty(replies) ? null : replies.get(0);

        }
    }

    public static Reply queryById(String database, long replyId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);
            return replyMapper.selectByPrimaryKey(replyId);
        }
    }

    public static Reply queryNext(String database, long topicId, long lastReplyId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);

            Example example = new Example(Reply.class);
            example.createCriteria()
                    .andEqualTo("topicId", topicId)
                    .andGreaterThan("id", lastReplyId);
            example.orderBy("id").asc();

            List<Reply> replies = replyMapper.selectByExampleAndRowBounds(example, new RowBounds(0, 1));

            return CollectionUtils.isEmpty(replies) ? null : replies.get(0);

        }
    }

    public static List<Reply> queryAllByTopicId(String database, long topicId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);

            Example example = new Example(Reply.class);
            example.createCriteria().andEqualTo("topicId", topicId);

            List<Reply> replies = replyMapper.selectByExample(example);

            return CollectionUtils.isEmpty(replies) ? null : replies;

        }
    }

    public static List<Reply> batchQueryByTopicId(String database, long topicId, int page, int pageSize) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);

            Example example = new Example(Reply.class);
            example.createCriteria().andEqualTo("topicId", topicId);

            // 计算offset和limit
            int offset = (page - 1) * pageSize;
            int limit = pageSize;
            List<Reply> replies = replyMapper.selectByExampleAndRowBounds(example, new RowBounds(offset, limit));

            return CollectionUtils.isEmpty(replies) ? null : replies;

        }
    }

    public static boolean updateContent(String database, long replyId, String content) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);

            Reply reply = new Reply();
            reply.setId(replyId);
            reply.setContent(content);
            int effect = replyMapper.updateByPrimaryKeySelective(reply);
            return effect > 0;
        }
    }

    public static boolean deleteByReplyId(String database, long replyId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);
            int effect = replyMapper.deleteByPrimaryKey(replyId);
            return effect > 0;
        }
    }

    public static boolean batchDeleteByTopicId(String database, long topicId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            ReplyMapper replyMapper = session.getMapper(ReplyMapper.class);

            Reply reply = new Reply();
            reply.setTopicId(topicId);

            int effect = replyMapper.delete(reply);

            return effect > 0;
        }
    }
}
