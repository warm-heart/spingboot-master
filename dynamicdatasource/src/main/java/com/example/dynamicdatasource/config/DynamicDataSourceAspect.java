package com.example.dynamicdatasource.config;

import com.example.dynamicdatasource.Enum.DataSourceKey;
import com.example.dynamicdatasource.annotation.TargetDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author wangqianlong
 * @create 2019-04-28 19:51
 */

@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {
    private static final Logger LOG = LoggerFactory.getLogger(DynamicDataSourceAspect.class);


    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        DataSourceKey dataSourceKey = targetDataSource.dataSourceKey();
        LOG.debug("使用数据源：" + dataSourceKey);
        DynamicDataSourceContextHolder.set(dataSourceKey);
    }


    /**
     * 执行方法后清除数据源设置
     *
     * @param joinPoint        切点
     * @param targetDataSource 动态数据源
     */
    @After("@annotation(targetDataSource)")
    public void doAfter(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        LOG.debug(" 当前数据源执行清理方法", targetDataSource.dataSourceKey());
        DynamicDataSourceContextHolder.clear();
    }

}
