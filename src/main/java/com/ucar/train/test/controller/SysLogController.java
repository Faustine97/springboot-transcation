package com.ucar.train.test.controller;

import com.ucar.train.test.services.UserService;
import com.ucar.train.test.vo.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class SysLogController {
    @Autowired
    private UserService userService;

    @RequestMapping("/syslog")
    public String syslog(HttpSession session)
    {
        int page = (Integer)session.getAttribute("syslog_page");
        List<SysLog> list = userService.selSyslog(page*10, 10);
        session.setAttribute("SysLog",list);

        return "syslog";
    }

    @RequestMapping("/pre_syslog")
    public void preSyslog(HttpSession session, HttpServletResponse response)
    {
        int page = (Integer) session.getAttribute("syslog_page");
        if(page>0)
        {
            session.setAttribute("syslog_page", page-1);
        }
        try {
            response.sendRedirect("/syslog");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/next_syslog")
    public void nextSyslog(HttpSession session, HttpServletResponse response)
    {
        int page = (Integer) session.getAttribute("syslog_page");
        System.out.println("syslog_page: " + page);
        int count = userService.getAllSyslogsCount();
        System.out.println("SyslogsCount: "+ count);
        if(((page+1)*10)<count)
        {
            session.setAttribute("syslog_page", page+1);
        }
        try {
            response.sendRedirect("/syslog");;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/search_syslog")
    public String searchSyslog(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        String operation = request.getParameter("operation");
        System.out.println("operation :" + operation);
        List<SysLog> list = userService.selSyslogWithOperation(operation);
        session.setAttribute("SysLog",list);
        return "syslog";
    }

}
