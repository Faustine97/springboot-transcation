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
    public String messageList(HttpSession session)
    {
        String user_name = (String)session.getAttribute("user");
        List<String> list = userService.getUserRole(user_name);
        List<String> group = userService.getUserGroup(user_name);
//        System.out.println("list: " +list);
//        System.out.println("group: "+ group);
        session.setAttribute("user_group",group);
        List<Guestbook> list1 = userService.getAllGuestbook(0,10);
        session.setAttribute("Guestbooks", list1);
        if(list!=null&&list.contains("admin"))
        {
            session.setAttribute("user_role","admin");
        }

        return "message_list";
    }

    @RequestMapping("/perm_error")
    public String permError()
    {
        return "perm_error";
    }
}
