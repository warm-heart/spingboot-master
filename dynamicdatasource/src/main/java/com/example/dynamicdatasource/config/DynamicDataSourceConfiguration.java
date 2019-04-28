package com.example.dynamicdatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.dynamicdatasource.Enum.DataSourceKey;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangqianlong
 * @create 2019-04-28 19:58
 */
@Configuration
@MapperScan(basePackages = "com.example.dynamicdatasource.dao")
public class DynamicDataSourceConfiguration {


    @Bean
    public DataSource dbMaster() {
        DataSource dataSource = new DruidDataSource();
        ((DruidDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/test1?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        ((DruidDataSource) dataSource).setPassword("1122");
        ((DruidDataSource) dataSource).setUsername("root");
        return dataSource;
    }

    @Bean
    public DataSource dbSlave1() {
        DataSource dataSource = new DruidDataSource();
        ((DruidDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/test2?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        ((DruidDataSource) dataSource).setPassword("1122");
        ((DruidDataSource) dataSource).setUsername("root");
        return dataSource;
    }

    @Bean
    public DataSource dbSlave2() {
        DataSource dataSource = new DruidDataSource();
        ((DruidDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/test3?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        ((DruidDataSource) dataSource).setPassword("1122");
        ((DruidDataSource) dataSource).setUsername("root");
        return dataSource;
    }

    @Bean
    public DataSource dbOther() {
        DataSource dataSource = new DruidDataSource();
        ((DruidDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/test4?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        ((DruidDataSource) dataSource).setPassword("1122");
        ((DruidDataSource) dataSource).setUsername("root");
        return dataSource;
    }

    @Bean
    public DataSource dynamicDataSource() {
        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
        dataSource.setDefaultTargetDataSource(dbMaster());
        Map<Object, Object> dataSourceMap = new HashMap<>(4);
        dataSourceMap.put(DataSourceKey.DB_MASTER, dbMaster());
        dataSourceMap.put(DataSourceKey.DB_SLAVE1, dbSlave1());
        dataSourceMap.put(DataSourceKey.DB_SLAVE2, dbSlave2());
        dataSourceMap.put(DataSourceKey.DB_OTHER, dbOther());
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        //此处设置为了解决找不到mapper文件的问题
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
