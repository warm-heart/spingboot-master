package com.example.dynamicdatasource.Service;

import com.example.dynamicdatasource.Enum.DataSourceKey;
import com.example.dynamicdatasource.annotation.TargetDataSource;
import com.example.dynamicdatasource.dao.Master;
import com.example.dynamicdatasource.dao.Slave;
import com.example.dynamicdatasource.entity.classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2019-04-28 20:45
 */
@Service
public class Test1Service {
    @Autowired
    private Slave slave;
    @Autowired
    private Master master;



    public List<classes> find() {
        return master.getclass1();
    }


    @TargetDataSource(dataSourceKey = DataSourceKey.DB_SLAVE1)
    public List<classes> find2(){
        return slave.getclass2();
    }
}
