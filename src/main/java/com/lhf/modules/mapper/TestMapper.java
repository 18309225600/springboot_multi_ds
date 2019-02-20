package com.lhf.modules.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @Author lhf
 * @Description
 * @Date 2019/2/20 11:38
 * @Version 1.0
 **/
public interface TestMapper {

    @Select("select * from test")
    void ds1();

    @Select("select * from test")
    void ds2();

    @Select("select * from test")
    void ds3();
}
