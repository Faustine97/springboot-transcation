package com.ucar.train.test.controller;

import com.ucar.train.test.services.UserService;
import com.ucar.train.test.services.impl.UserServiceImpl;
import com.ucar.train.test.vo.Guestbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private UserService userService;
    @RequestMapping("/message_create")
    public String messageCreate(HttpSession session)
    {
        String user_name = (String)session.getAttribute("user");
        List<Guestbook> list = userService.getUserGuestbooks(user_name);
        session.setAttribute("Guestbook",list);
        return "message_create";
    }

    @RequestMapping("/message_list")
    public String messageList()
    {

        return "message_list";
    }
}
