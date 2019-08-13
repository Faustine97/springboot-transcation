package com.ucar.train.test.controller;

import com.ucar.train.test.services.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpSession session){

        session.setAttribute("user",null);
        //session.setAttribute("user", );
        return "login";
    }

    @RequestMapping("/log_out")
    public String logOut()
    {
        return "login";
    }

    @RequestMapping("/login_check")

    public String loginCheck(HttpServletRequest request)
    {
        UserServiceImpl impl = new UserServiceImpl();
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        if(impl.checkLogin(user,password)==true)
        {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "message_list";
        }
        return "login";
    }
}
