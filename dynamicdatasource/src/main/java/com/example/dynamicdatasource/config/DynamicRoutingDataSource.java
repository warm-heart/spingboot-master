package com.example.dynamicdatasource.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author wangqianlong
 * @create 2019-04-28 19:49
 */

public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    private static final Logger logger = LoggerFactory.getLogger(DynamicRoutingDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("当前数据源：{}" + DynamicDataSourceContextHolder.get());
        return DynamicDataSourceContextHolder.get();
    }
}
