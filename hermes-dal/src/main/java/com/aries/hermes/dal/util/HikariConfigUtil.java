package com.aries.hermes.dal.util;

import com.aries.hermes.core.utils.PropertiesProxy;
import com.codahale.metrics.MetricRegistry;
import com.zaxxer.hikari.HikariConfig;

public class HikariConfigUtil {
    /**
     * jdbcUrl的生成模板
     */
    private static final String JDBC_URL_TEMPLET = "%s%s:%s/%s%s";

    /**
     * 开放接口，新建Hikari配置对象，从database.properties中读取信息，
     * 配置了mysql的基本连接（用户名，密码），并配置一些性能指标。
     *
     * @param databaseName 根据传入的数据库名，来配置要连接哪个数据库。
     * @return Hikari配置对象
     */
    public static HikariConfig getHikariConfig(String databaseName) {
        HikariConfig config = initHikariConfigFromProperties(databaseName);
        setMoreDetails(config);
        return config;
    }

    /**
     * 根据 {@code JDBC_URL_TEMPLET} 来生成jdbc url
     *
     * @return jdbc url
     */
    private static final String getJdbcUrl(String dbproxy, String host, String port, String databaseName, String params) {
        return String.format(JDBC_URL_TEMPLET, dbproxy, host, port, databaseName, params);
    }

    /**
     * <p>新建了Hikari配置对象，配置了jdbcUrl, username, password 这些基本连接信息。
     * <p>数据是从database.properties中读取的。
     *
     * @param databaseName 要连接的数据库名
     * @return Hikari配置对象
     */
    private static final HikariConfig initHikariConfigFromProperties(String databaseName) {
        PropertiesProxy propertiesProxy = new PropertiesProxy("database.properties");
        String dbproxy = propertiesProxy.readProperty("dbproxy");
        String host = propertiesProxy.readProperty("host");
        String port = propertiesProxy.readProperty("port");
        String params = propertiesProxy.readProperty("params");
        String username = propertiesProxy.readProperty("username");
        String password = propertiesProxy.readProperty("password");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(getJdbcUrl(dbproxy, host, port, databaseName, params));
        config.setUsername(username);
        config.setPassword(password);
        return config;
    }

    private static void setMoreDetails(HikariConfig config) {
        // 缓存编译后的PreparedStatement
        config.addDataSourceProperty("cachePrepStmts", "true");
        // PreparedStatement缓存大小
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        //可以控制长度多大的sql可以被缓存，MySQL驱动默认是256，通常实践中往往设置为2048
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        //如果不开启rewriteBatchedStatements=true，那么jdbc会把批量插入当做一行行的单条处理，也即没有达到批量插入的效果
        config.addDataSourceProperty("rewriteBatchedStatements", "true");
        config.setValidationTimeout(3000);
        //连接只读数据库时配置为true， 保证安全
        config.setReadOnly(false);
        //自动提交
        config.setAutoCommit(true);
        //等待连接池分配连接的最大时长（毫秒），超过这个时长还没可用的连接则发生SQLException， 缺省:30秒
        config.setConnectionTimeout(30000);
        //个连接idle状态的最大时长（毫秒），超时则被释放（retired），缺省:10分钟
        config.setIdleTimeout(600000);
        // 一个连接的生命时长（毫秒），超时而且没被使用则被释放（retired），缺省:30分钟，建议设置比数据库超时时长少30秒，参考MySQL wait_timeout参数（show variables like '%timeout%';）
        config.setMaxLifetime(1800000);
        //连接池中允许的最大连接数。缺省值：10；推荐的公式：((core_count * 2) + effective_spindle_count)
        config.setMaximumPoolSize(4);
        //用于监控
        config.setMetricRegistry(new MetricRegistry());
    }


}
