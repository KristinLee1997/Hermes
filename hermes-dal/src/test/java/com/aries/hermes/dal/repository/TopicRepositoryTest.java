package com.aries.hermes.dal.repository;

import com.aries.hermes.dal.exception.BatchQueryException;
import com.aries.hermes.dal.po.Topic;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.List;

public class TopicRepositoryTest {

    /**
     * 新增主帖
     */
    @Test
    public void addTopic() {
        Topic topic = new Topic() {{
            setTheme("怎样更优雅的编程？");
            setContent("我即将成为毕业生，对未来很困惑，希望圈里的大佬们可以指条明路，多谢~");
            setAnonymousReply(false);
            setAnonymousSend(false);
            setCategoryId(1L);
            setGaeaId(115203L);
        }};
        boolean res = TopicRepository.addTopic("hermes_aries_edu", topic);
        System.out.println(res);
    }

    /**
     * 根据条件查询主帖
     */
    @Test
    public void selectBySelective() {
        Topic topic = new Topic() {{
            setCategoryId(1L);
        }};
        List<Topic> topicList = TopicRepository.selectBySelective("hermes_aries_edu", topic);
        if (!CollectionUtils.isEmpty(topicList)) {
            System.out.println(topicList.size());
        }
    }

    /**
     * 查询所有topic
     */
    @Test
    public void selectAll() {
        List<Topic> topicList = TopicRepository.selectAll("hermes_aries_edu");
        if (!CollectionUtils.isEmpty(topicList)) {
            System.out.println(topicList);
        }
    }

    /**
     * 批量查询主帖
     */
    @Test
    public void batchQueryTopics() throws BatchQueryException {
        List<Topic> topicList = TopicRepository.batchQueryTopics("hermes_aries_edu", 1, 1);
        if (!CollectionUtils.isEmpty(topicList)) {
            System.out.println(topicList);
        }
    }

    /**
     * 根据主帖id删除主帖
     */
    @Test
    public void deleteById() {
        boolean res = TopicRepository.deleteById("hermes_aries_edu", 1L);
        System.out.println(res);
    }

    /**
     * 根据主键更新主帖字段
     */
    @Test
    public void updateTopic() {
        Topic topic = new Topic() {{
            setTheme("新主帖");
        }};
        TopicRepository.updateTopic("hermes_aries_edu", 1L, topic);
    }
}
