package com.aries.hermes.dal.repository;

import com.aries.hermes.dal.mapper.SubReplyMapper;
import com.aries.hermes.dal.po.SubReply;
import com.aries.hermes.dal.util.SqlSessionUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class SubReplyRepository {
    public static boolean addSubReply(String database, SubReply subReply) {
        subReply.setId(null);
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            SubReplyMapper replyMapper = session.getMapper(SubReplyMapper.class);
            int effect = replyMapper.insertSelective(subReply);
            return effect > 0;
        }
    }

    public static SubReply queryFirst(String database, long replyId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            SubReplyMapper replyMapper = session.getMapper(SubReplyMapper.class);

            Example example = new Example(SubReply.class);
            example.createCriteria().andEqualTo("replyId", replyId);
            example.orderBy("id").asc();

            List<SubReply> replies = replyMapper.selectByExampleAndRowBounds(example, new RowBounds(0, 1));

            return CollectionUtils.isEmpty(replies) ? null : replies.get(0);

        }
    }

    public static SubReply queryById(String database, long subReplyId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            SubReplyMapper replyMapper = session.getMapper(SubReplyMapper.class);
            return replyMapper.selectByPrimaryKey(subReplyId);
        }
    }

    public static SubReply queryNext(String database, long replyId, long lastReplyId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            SubReplyMapper replyMapper = session.getMapper(SubReplyMapper.class);

            Example example = new Example(SubReply.class);
            example.createCriteria()
                    .andEqualTo("replyId", replyId)
                    .andGreaterThan("id", lastReplyId);
            example.orderBy("id").asc();

            List<SubReply> replies = replyMapper.selectByExampleAndRowBounds(example, new RowBounds(0, 1));

            return CollectionUtils.isEmpty(replies) ? null : replies.get(0);

        }
    }

    public static List<SubReply> queryAllByReplyId(String database, long replyId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            SubReplyMapper replyMapper = session.getMapper(SubReplyMapper.class);

            Example example = new Example(SubReply.class);
            example.createCriteria().andEqualTo("replyId", replyId);

            List<SubReply> replies = replyMapper.selectByExample(example);

            return CollectionUtils.isEmpty(replies) ? null : replies;

        }
    }

    public static List<SubReply> batchQueryByReplyId(String database, long replyId, int page, int pageSize) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            SubReplyMapper replyMapper = session.getMapper(SubReplyMapper.class);

            Example example = new Example(SubReply.class);
            example.createCriteria().andEqualTo("replyId", replyId);

            // 计算offset和limit
            int offset = (page - 1) * pageSize;
            int limit = pageSize;
            List<SubReply> replies = replyMapper.selectByExampleAndRowBounds(example, new RowBounds(offset, limit));

            return CollectionUtils.isEmpty(replies) ? null : replies;

        }
    }

    public static boolean updateContent(String database, long subReplyId, String content) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            SubReplyMapper replyMapper = session.getMapper(SubReplyMapper.class);

            SubReply reply = new SubReply();
            reply.setId(subReplyId);
            reply.setContent(content);
            int effect = replyMapper.updateByPrimaryKeySelective(reply);
            return effect > 0;
        }
    }

    public static boolean deleteBySubReplyId(String database, long subReplyId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            SubReplyMapper replyMapper = session.getMapper(SubReplyMapper.class);
            int effect = replyMapper.deleteByPrimaryKey(subReplyId);
            return effect > 0;
        }
    }

    public static boolean batchDeleteByReplyId(String database, long replyId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            SubReplyMapper replyMapper = session.getMapper(SubReplyMapper.class);

            SubReply reply = new SubReply();
            reply.setReplyId(replyId);

            int effect = replyMapper.delete(reply);

            return effect > 0;
        }
    }

    public static long getSubReplyCount(String database, long replyId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            SubReplyMapper replyMapper = session.getMapper(SubReplyMapper.class);

            SubReply reply = new SubReply();
            reply.setReplyId(replyId);

            return replyMapper.selectCount(reply);
        }
    }
}
