package com.aries.hermes.dal.util;

import com.aries.hermes.dal.constants.SystemConstants;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SqlSessionUtil {
    public static SqlSession openSession(String databaseName) {
        SqlSessionFactory sqlSessionFactory = null;
        if (databaseName.equals(SystemConstants.SYSTEM_DATABASE_NAME)) {
            sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory(databaseName);
        } else {
            sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory(SystemConstants.DATABASE_NAME_PREFIX + databaseName);
        }
        return sqlSessionFactory.openSession(true);
    }
}
