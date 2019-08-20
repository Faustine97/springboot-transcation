package com.ucar.train.test.controller;

import com.ucar.train.test.function.MyLog;
import com.ucar.train.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @MyLog(operation = "访问管理员后台", result = "成功")
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }


    @RequestMapping("/create_role")
    public void createRole(HttpServletRequest request, HttpServletResponse response) {
        try {
            String role = request.getParameter("role");
            String info = request.getParameter("info");
            userService.addRole(role, info);
            response.sendRedirect("/create_role_success");
        } catch (Exception e) {
            try {
                response.sendRedirect("/create_role_fail");
            } catch (Exception e1) {
            }
        }

    }

    @MyLog(operation = "创建角色", result = "成功")
    @RequestMapping("/create_role_success")
    public String createRoleSuccess() {
        return "success";
    }

    @MyLog(operation = "创建角色", result = "失败")
    @RequestMapping("/create_role_fail")
    public String createRoleFail() {
        return "fail";
    }

    @RequestMapping("/delete_role")
    public void deleteRole(HttpServletRequest request, HttpServletResponse response) {
        try {
            String role = request.getParameter("role");
            userService.deleteRole(role);
            response.sendRedirect("/delete_role_success");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.sendRedirect("/delete_role_fail");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @MyLog(operation = "删除角色", result = "失败")
    @RequestMapping("/delete_role_fail")
    public String CreateRoleFail() {
        return "success";
    }

    @MyLog(operation = "删除角色", result = "成功")
    @RequestMapping("/delete_role_success")
    public String deleteRoleSuccess() {
        return "fail";
    }


    @RequestMapping("/add_role_perm")
    public void addRolePerm(HttpServletRequest request, HttpServletResponse response) {
        String role = request.getParameter("role");
        String perm = request.getParameter("perm");
        try {
            userService.addRolePerm(role, perm);
            response.sendRedirect("/add_role_perm_success");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.sendRedirect("/add_role_perm_fail");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @MyLog(operation = "增加角色权限", result = "成功")
    @RequestMapping("/add_role_perm_success")
    public String addRolePermSuccess() {
        return "success";
    }

    @MyLog(operation = "增加角色权限", result = "失败")
    @RequestMapping("/add_role_perm_fail")
    public String addRolePermFail() {
        return "fail";
    }

    @RequestMapping("/delete_role_perm")
    public void deleteRolePerm(HttpServletRequest request, HttpServletResponse response) {
        String role = request.getParameter("role");
        String perm = request.getParameter("perm");
        try {
            if (userService.deleteRolePerm(role, perm))
                response.sendRedirect("/delete_role_perm_success");
            else
                response.sendRedirect("/delete_role_perm_fail");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.sendRedirect("/delete_role_perm_fail");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @MyLog(operation = "删除角色权限", result = "成功")
    @RequestMapping("/delete_role_perm_success")
    public String deleteRolePermSuccess() {
        return "success";
    }

    @MyLog(operation = "删除角色权限", result = "失败")
    @RequestMapping("/delete_role_perm_fail")
    public String deleteRolePermFail() {
        return "fail";
    }

    @RequestMapping("/user_add_role")
    public void userAddRole(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("user");
        String role = request.getParameter("role");
        try {
            userService.userAddRole(role, user);
            response.sendRedirect("/user_add_role_success");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.sendRedirect("/user_add_role_fail");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @MyLog(operation = "增加用户角色", result = "成功")
    @RequestMapping("/user_add_role_success")
    public String userAddRoleSuccess() {
        return "success";
    }

    @MyLog(operation = "增加用户角色", result = "失败")
    @RequestMapping("/user_add_role_fail")
    public String userAddRoleFail() {
        return "fail";
    }

    @RequestMapping("/user_delete_role")
    public void userDeleteRole(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("user");
        String role = request.getParameter("role");
        try {
            userService.userDeleteRole(user, role);
            response.sendRedirect("/user_delete_role_success");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.sendRedirect("/user_delete_role_fail");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @MyLog(operation = "删除用户角色", result = "成功")
    @RequestMapping("/user_delete_role_success")
    public String userDeleteRoleSuccess() {
        return "success";
    }

    @MyLog(operation = "删除用户角色", result = "失败")
    @RequestMapping("/user_delete_role_fail")
    public String userDeleteRoleFail() {
        return "fail";
    }


}
