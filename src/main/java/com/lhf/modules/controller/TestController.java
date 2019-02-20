package com.lhf.modules.controller;

import com.lhf.modules.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author lhf
 * @Description
 * @Date 2019/2/20 11:34
 * @Version 1.0
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/ds1")
    public void ds1(){
        testService.ds1();
    }

    @GetMapping("/ds2")
    public void ds2(){
        testService.ds2();
    }

    @GetMapping("/ds3")
    public void ds3(){
        testService.ds3();
    }

}
