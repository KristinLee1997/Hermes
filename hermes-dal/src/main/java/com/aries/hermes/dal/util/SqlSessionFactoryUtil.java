package com.aries.hermes.dal.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.mybatis.mapper.session.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SqlSessionFactoryUtil {
    private static Map<String, SqlSessionFactory> sqlSessionFactoryMap = new ConcurrentHashMap<>();

    public static SqlSessionFactory getSqlSessionFactory(String databaseName) {
        if (!sqlSessionFactoryMap.containsKey(databaseName)) {
            Configuration configuration = ConfigurationUtil.getTkConfigurationByDBName(databaseName);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sessionFactory = builder.build(configuration);
            sqlSessionFactoryMap.putIfAbsent(databaseName, sessionFactory);
            //新建的sessionFactory建议不要直接return出去。要统一使用sqlSessionFactoryMap.get(databaseName)
        }
        return sqlSessionFactoryMap.get(databaseName);
    }
}
