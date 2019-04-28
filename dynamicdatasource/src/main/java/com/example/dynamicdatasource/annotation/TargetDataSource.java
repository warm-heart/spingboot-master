package com.example.dynamicdatasource.annotation;

import com.example.dynamicdatasource.Enum.DataSourceKey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangqianlong
 * @create 2019-04-28 19:42
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {

    DataSourceKey dataSourceKey() default DataSourceKey.DB_MASTER;
}
