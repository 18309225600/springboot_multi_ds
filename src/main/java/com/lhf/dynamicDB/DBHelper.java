package com.lhf.dynamicDB;

import org.springframework.stereotype.Component;

/**
 * @Author lhf
 * @Description
 * @Date 2019/2/20 12:43
 * @Version 1.0
 **/
@Component
public class DBHelper {
    private ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public String get(){
        String dataSource = this.contextHolder.get();
        if (dataSource==null||dataSource.trim().length()<1){
            //默认master
            dataSource = DataSourceType.MASTER;
        }
        return dataSource;
    }

    public void set(String dataSource){
        this.contextHolder.set(dataSource);
    }

    public void clean(){
        this.contextHolder.remove();
    }

}
