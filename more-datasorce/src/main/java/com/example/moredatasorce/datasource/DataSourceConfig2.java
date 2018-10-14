package com.example.moredatasorce.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author wangqianlong
 * @create 2018-10-14 13:39
 */
@Configuration
@MapperScan(basePackages = DataSourceConfig2.PACKAGE, sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class DataSourceConfig2 {
    static final String PACKAGE = "com.example.moredatasorce.dao.slave";
    static final String MAPPER_LOCATION = "classpath:mapper/slave/*.xml";


    @Value("${slave_mysql_url}")
    private String dbUrl;
    @Value("${slave_mysql_username}")
    private String dbUser;
    @Value("${slave_mysql_password}")
    private String dbPassword;

    @Bean(name = "slaveDataSource")

    public DataSource slaveDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean(name = "slaveTransactionManager")

    public DataSourceTransactionManager rdsTransactionManager() {
        return new DataSourceTransactionManager(slaveDataSource());
    }

    @Bean(name = "slaveSqlSessionFactory")

    public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource slaveDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(slaveDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceConfig2.MAPPER_LOCATION));

        return sessionFactory.getObject();
    }
}
