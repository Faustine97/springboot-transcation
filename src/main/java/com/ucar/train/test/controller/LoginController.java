package com.ucar.train.test.controller;

import com.ucar.train.test.function.MyLog;
import com.ucar.train.test.services.UserService;
import com.ucar.train.test.services.impl.UserServiceImpl;
import com.ucar.train.test.vo.Guestbook;
import com.ucar.train.test.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpSession session){

        session.setAttribute("user",null);
        session.setAttribute("user_role",null);
        session.setAttribute("page",null);

        return "login";

    }

    @RequestMapping("/log_out")
    public String logOut()
    {
        return "login";
    }

    @RequestMapping("/login_check")

    public void loginCheck(HttpServletRequest request, HttpServletResponse response)
    {
        UserServiceImpl impl = new UserServiceImpl();
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        if(impl.checkLogin(user,password)==true)
        {
            User user1 = userService.getUser(user);
            List<String> perm = userService.getUserPerm(user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("user_id", user1.getUser_id());
            session.setAttribute("perms", perm);
            session.setAttribute("User",user1);
            session.setAttribute("page",0);
            session.setAttribute("syslog_page",0);
            try {
                response.sendRedirect("/login_success");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try{
                response.sendRedirect("/login_fail");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @MyLog(operation = "登录",result = "成功")
    @RequestMapping("/login_success")
    public void LoginSuccess(HttpServletResponse response)
    {
        try{
            response.sendRedirect("/message_list");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @MyLog(operation = "登录",result = "失败")
    @RequestMapping("/login_fail")
    public void LoginFail(HttpServletResponse response)
    {
        try{
            response.sendRedirect("/login");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
