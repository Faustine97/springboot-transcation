package com.ucar.train.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/user_edit")
    public String userEdit()
    {
        return "user_edit";
    }
    @RequestMapping("/user_info")
    public String userInfo()
    {
        return "user_info";
    }
}
