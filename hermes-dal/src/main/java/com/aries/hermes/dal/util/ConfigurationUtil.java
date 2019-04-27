package com.aries.hermes.dal.util;

import com.github.pagehelper.PageInterceptor;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import tk.mybatis.mapper.session.Configuration;

public class ConfigurationUtil {

    public static Configuration getTkConfigurationByDBName(String databaseName) {
        // 新建一个configuration
        Configuration configuration = new Configuration();

        configuration.addInterceptor(new PageInterceptor());

        // 根据数据库名新建连接池配置
        HikariConfig config = HikariConfigUtil.getHikariConfig(databaseName);

        // 根据连接池配置新建连接池
        HikariDataSource dataSource = new HikariDataSource(config);

        // 把SqlMapConfig.xml里的environment元素添加进来
        configuration.setEnvironment(new Environment(databaseName, new JdbcTransactionFactory(), dataSource));

        // 把tk.mybatis的MapperHelper添加进来
        configuration.setMapperHelper(TkMapperHelperUtil.getMapperHelper(configuration));

        // 指定mapper的扫描路径
        configuration.addMappers("com.aries.hermes.dal.mapper");

        return configuration;
    }
}
