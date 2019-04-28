package com.aries.hermes.dal.util;

import com.aries.hermes.dal.constants.SystemConstants;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SqlSessionUtil {
    public static SqlSession openSession(String databaseName) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory(databaseName);
        return sqlSessionFactory.openSession(true);
    }
}
