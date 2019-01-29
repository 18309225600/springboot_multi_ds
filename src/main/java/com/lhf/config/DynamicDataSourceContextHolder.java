package com.lhf.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lhf
 * @Description
 * @Date 2019/1/29 16:07
 * @Version 1.0
 * @Description 动态数据源上下文，用于存储数据源
 **/
public class DynamicDataSourceContextHolder {
    //每个线程独立的副本
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    //所有的数据源ID
    public static List<String> dataSourceIds = new ArrayList<String>();

    public static void setDataSourceType(String dataSourceType){
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType(){
        return contextHolder.get();
    }

    public static void cleanDataSrouceType(){
        contextHolder.remove();
    }


    /**
     * 判断指定的数据源是否存在
     * @param dataSourceId
     * @return
     */
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }

}
