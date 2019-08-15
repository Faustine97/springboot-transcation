package com.ucar.train.test.controller;

import com.ucar.train.test.function.MyLog;
import com.ucar.train.test.services.UserService;
import com.ucar.train.test.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

@Controller
public class GuestbooksController {
    @Autowired
    UserService userService;

    @MyLog(operation = "删除留言", result = "成功")
    @RequestMapping("/deleteGuestbook")
    public String deleteGuestbook(HttpServletRequest request, HttpServletResponse response)
    {
        int id = Integer.parseInt(request.getParameter("messageId")) ;
        System.out.println(id);
        userService.deleteGuestbook(id);
        try {
            response.sendRedirect("/message_list");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "message_list";
    }

    @MyLog(operation = "更新留言",result = "成功")
    @RequestMapping("/updateGuestbook")
    public String updateGuestbook(HttpServletRequest request, HttpServletResponse response)
    {
        int id = Integer.parseInt(request.getParameter("messageId")) ;
        String messageTitle = request.getParameter("messageTitle");
        String messageContent = request.getParameter("messageContent");
        Timestamp messageEditTime = new Timestamp(System.currentTimeMillis());
        userService.updateGuestbook(messageTitle,messageContent,messageEditTime,id);
        try {
            response.sendRedirect("/message_list");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "message_list";
    }

    @RequestMapping("/message_create_update_guestbook")
    public String messageCreateUpdateGuestbook(HttpServletRequest request,HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("messageId")) ;
        String messageTitle = request.getParameter("messageTitle");
        String messageContent = request.getParameter("messageContent");
        Timestamp messageEditTime = new Timestamp(System.currentTimeMillis());
        userService.updateGuestbook(messageTitle,messageContent,messageEditTime,id);
        try {
            response.sendRedirect("/message_create");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "message_create";
    }

    @MyLog(operation = "添加留言",result = "成功")
    @RequestMapping("/add_guestbook")
    public String messageCreateAddGuestbook(HttpServletRequest request, HttpServletResponse response)
    {
        String message_title = request.getParameter("message_title");
        String message_content = request.getParameter("message_content");
        Timestamp messageEditTime = new Timestamp(System.currentTimeMillis());
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        System.out.println(user.toString());
        int id = user.getUser_id();
        userService.addGuestbook(message_title,message_content,messageEditTime,messageEditTime, id);

        try {
            response.sendRedirect("/message_create");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "message_create";
    }
}
