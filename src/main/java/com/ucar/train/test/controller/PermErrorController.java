package com.ucar.train.test.controller;

import com.ucar.train.test.function.MyLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PermErrorController {
    @MyLog(operation = "访问管理员后台", result = "失败")
    @RequestMapping("/admin_perm_error")
    public String adminPermError() {
        return "perm_error";
    }

    @MyLog(operation = "访问信息编辑界面", result = "失败")
    @RequestMapping("/user_edit_perm_error")
    public String userEditPermError() {
        return "perm_error";
    }

    @MyLog(operation = "访问用户列表界面", result = "失败")
    @RequestMapping("/user_info_perm_error")
    public String userInfoPermError() {
        return "perm_error";
    }

    @MyLog(operation = "访问留言界面", result = "失败")
    @RequestMapping("/message_create_perm_error")
    public String messageCreatePermError() {
        return "perm_error";
    }

    @MyLog(operation = "删除留言", result = "失败")
    @RequestMapping("/deleteGuestbook_perm_error")
    public String deleteGuestbookPermError() {
        return "perm_error";
    }

    @MyLog(operation = "修改留言", result = "失败")
    @RequestMapping("/updateGuestbook_perm_error")
    public String updateGuestbookPermError() {
        return "perm_error";
    }

    @RequestMapping("/syslog_perm_error")
    public String syslogPermError() {
        return "perm_error";
    }

}
