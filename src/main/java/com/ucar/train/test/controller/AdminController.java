package com.ucar.train.test.controller;

import com.ucar.train.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @RequestMapping("/admin")
    public String admin()
    {
        return "admin";
    }


    @RequestMapping("/create_role")
    public String CreateRole(HttpServletRequest request)
    {
        try {
            String role = request.getParameter("role");
            String info = request.getParameter("info");
            userService.addRole(role,info);
            return "success";
        }catch (Exception e){
            return "fail";
        }

    }
    @RequestMapping("/add_role_perm")
    public String AddRolePerm(HttpServletRequest request)
    {
        String role = request.getParameter("role");
        String perm = request.getParameter("perm");
        try {
            userService.addRolePerm(role, perm);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @RequestMapping("/delete_role_perm")
    public String deleteRolePerm(HttpServletRequest request)
    {
        String role = request.getParameter("role");
        String perm = request.getParameter("perm");
        try {
            if(userService.deleteRolePerm(role, perm))
               return "success";
            else
                return "fail";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @RequestMapping("/user_add_role")
    public String UserAddRole(HttpServletRequest request)
    {
        String user = request.getParameter("user");
        String role = request.getParameter("role");
        try {
            userService.userAddRole(role,user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }
    @RequestMapping("/user_delete_role")
    public String UserDeleteRole(HttpServletRequest request)
    {
        String user = request.getParameter("user");
        String role = request.getParameter("role");
        try {
            userService.userDeleteRole(user,role);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }

}
