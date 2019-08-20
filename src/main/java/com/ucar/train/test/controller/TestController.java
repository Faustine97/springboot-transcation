package com.ucar.train.test.controller;

import com.ucar.train.test.function.MyLog;
import com.ucar.train.test.services.UserService;
import com.ucar.train.test.services.impl.UserHeadService;
import com.ucar.train.test.util.GsonUtils;
import com.ucar.train.test.vo.UserHead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserHeadService userHeadService;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @RequestMapping("/hello")
    public String say() {
        return driverClassName;
    }


    // @MyLog(value = "测试")
    @RequestMapping("/test")
    public String getAllUser() {
        return userHeadService.getUserHead("Tom").toString();
//        return userService.getAllRole().toString();
        //return GsonUtils.toJson(new Timestamp(System.currentTimeMillis()));
    }

    @RequestMapping("/test2")
    //
    public String test2() {

        return userHeadService.getHistoryHead("Tom").toString();
    }

}
