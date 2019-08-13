package com.ucar.train.test.controller;

import com.ucar.train.test.services.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MessageController {
    @RequestMapping("/message_create")
    public String messageCreate()
    {
        return "message_create";
    }

    @RequestMapping("/message_list")
    public String messageList()
    {
        return "message_list";
    }
}
