package com.lhf.dynamicDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author lhf
 * @Description
 * @Date 2019/2/20 12:42
 * @Version 1.0
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Autowired
    private DBHelper dbHelper;
    @Override
    protected Object determineCurrentLookupKey() {
        return dbHelper.get();
    }
}
