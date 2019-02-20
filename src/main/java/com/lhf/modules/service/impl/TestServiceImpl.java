package com.lhf.modules.service.impl;

import com.lhf.dynamicDB.DataSourceType;
import com.lhf.dynamicDB.TargetDataSource;
import com.lhf.modules.mapper.TestMapper;
import com.lhf.modules.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lhf
 * @Description
 * @Date 2019/2/20 11:36
 * @Version 1.0
 **/
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    @TargetDataSource(DataSourceType.MASTER)
    public void ds1() {
        testMapper.ds1();
    }

    @Override
    @TargetDataSource(DataSourceType.SLAVE1)
    public void ds2() {
        testMapper.ds2();
    }

    @Override
    @TargetDataSource(DataSourceType.SLAVE2)
    public void ds3() {
        testMapper.ds3();
    }
}
