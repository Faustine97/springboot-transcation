package com.ucar.train.test.controller;

import com.ucar.train.test.services.UserService;
import com.ucar.train.test.services.impl.UserServiceImpl;
import com.ucar.train.test.vo.Guestbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        int page = (Integer) session.getAttribute("page");

        List<Guestbook> list1 = userService.getAllGuestbook(page*10,10);
        session.setAttribute("Guestbooks", list1);
        if(list!=null&&list.contains("admin"))
        {
            session.setAttribute("user_role","admin");
        }

        return "message_list";
    }

    @RequestMapping("pre_page")
    public void prePage(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        int page = (Integer) session.getAttribute("page");
        if(page>0)
        {
            session.setAttribute("page", page-1);
        }
        try {
            response.sendRedirect("/message_list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("next_page")
    public void nextPage(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        int page = (Integer) session.getAttribute("page");
        int count = userService.getAllGuestbooksCount();
        if(((page+1)*10)<count)
        {
            session.setAttribute("page", page+1);
        }

        try {
            response.sendRedirect("/message_list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/perm_error")
    public String permError()
    {
        return "perm_error";
    }
}
