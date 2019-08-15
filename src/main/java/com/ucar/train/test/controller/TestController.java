package com.ucar.train.test.controller;

import com.ucar.train.test.function.MyLog;
import com.ucar.train.test.services.UserService;
import com.ucar.train.test.util.GsonUtils;
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
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @RequestMapping("/hello")
    public String say(){
        return driverClassName;
    }


    @MyLog(value = "测试")
    @RequestMapping("/test")
    public String getAllUser(){

        return GsonUtils.toJson(new Timestamp(System.currentTimeMillis()));
    }

    @RequestMapping("/test2")
   //
    public void test2()
    {
        userService.deleteRole("asdf");
    }

}
