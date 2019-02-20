package com.lhf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

/**
 * @Author lhf
 * @Description
 * @Date 2019/1/29 15:39
 * @Version 1.0
 *
 * 解除springboot数据源自动装配
 * 配置扫描mapper的位置
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
@MapperScan(basePackages = {"com.lhf.modules.mapper","com.lhf.modules.mapper.*"})
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
