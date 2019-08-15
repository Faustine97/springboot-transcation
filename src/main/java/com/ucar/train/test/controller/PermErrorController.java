package com.ucar.train.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PermErrorController {

    @RequestMapping("/admin_perm_error")
    public String adminPermError()
    {
        return "perm_error";
    }
    @RequestMapping("/user_edit_perm_error")
    public String userEditPermError()
    {
        return "perm_error";
    }
    @RequestMapping("/user_info_perm_error")
    public String userInfoPermError()
    {
        return "perm_error";
    }
    @RequestMapping("/message_create_perm_error")
    public String messageCreatePermError()
    {
        return "perm_error";
    }
    @RequestMapping("/deleteGuestbook_perm_error")
    public String deleteGuestbook_perm_errorPermError()
    {
        return "perm_error";
    }
    @RequestMapping("/updateGuestbook_perm_error")
    public String updateGuestbook_perm_errorPermError()
    {
        return "perm_error";
    }
}
