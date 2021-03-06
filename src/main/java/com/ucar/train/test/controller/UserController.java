package com.ucar.train.test.controller;

import com.ucar.train.test.function.MyLog;
import com.ucar.train.test.services.AccountService;
import com.ucar.train.test.services.UserService;
import com.ucar.train.test.vo.Account;
import com.ucar.train.test.vo.User;
import com.ucar.train.test.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
    @MyLog(operation = "访问信息编辑界面", result = "成功")
    @RequestMapping("/user_edit")
    public String userEdit(HttpSession session) {
        String user_name = (String) session.getAttribute("user");
        User user = userService.getUser(user_name);
        session.setAttribute("user_edit", user);
        Account account = accountService.getUserAccount(user.getUser_id());
        session.setAttribute("user_account",account);
        return "user_edit";
    }

    @MyLog(operation = "更新个人信息", result = "成功")
    @RequestMapping("/user_edit_update")
    public void userEditUpdate(HttpServletRequest request, HttpServletResponse response) {
        String user_name = request.getParameter("user_name");
        String user_password = request.getParameter("user_password");
        String user_email = request.getParameter("user_email");
        String user_telephone = request.getParameter("user_telephone");
        User user = new User(user_name, user_password, user_email, user_telephone);
        //userService.updateUser(user_name, user_password, user_email, user_telephone);
        userService.updateUser(user);
        try {
            response.sendRedirect("/user_edit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @MyLog(operation = "访问用户列表界面", result = "成功")
    @RequestMapping("/user_info")
    public String userInfo(HttpSession session) {
        List<UserInfo> list = userService.getAllUserInfo();
        session.setAttribute("UserInfo", list);
        return "user_info";
    }
}
