package com.aries.hermes.dal;

import com.aries.hermes.dal.mapper.StuMapper;
import com.aries.hermes.dal.po.Stu;
import com.aries.hermes.dal.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;

public class TkMapperTest {
    @Test
    public void simpleTest() {
        try (SqlSession session = SqlSessionUtil.openSession("test")) {
            // 获取Mapper
            StuMapper stuMapper = session.getMapper(StuMapper.class);

            // 构建example
            Example example = new Example(Stu.class);
            example.setForUpdate(true);
            example.createCriteria().andBetween("id", 1, 3);

            // 输出结果
            System.out.println(stuMapper.selectByExample(example));
        }
    }
}
