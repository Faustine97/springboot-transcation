package com.ucar.train.test.controller;

import com.ucar.train.test.services.UserService;
import com.ucar.train.test.services.impl.UserServiceImpl;
import com.ucar.train.test.vo.Guestbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

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
            List<Guestbook> list = userService.getAllGuestbook(0,10);
            session.setAttribute("Guestbooks", list);

            return "message_list";
        }
        return "login";
    }
}
