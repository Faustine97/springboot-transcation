package com.ucar.train.test.intercepors;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        List<String> perms = (List<String>) session.getAttribute("perms");
        String perm = request.getServletPath();
        if (perms != null && perms.contains(perm))
            return true;
        else {
            switch (perm) {
                case "/admin":
                    response.sendRedirect("/admin_perm_error");
                    break;
                case "/user_edit":
                    response.sendRedirect("/user_edit_perm_error");
                    break;
                case "/user_info":
                    response.sendRedirect("/user_info_perm_error");
                    break;
                case "/message_create":
                    response.sendRedirect("/message_create_perm_error");
                    break;
                case "/deleteGuestbook":
                    response.sendRedirect("/deleteGuestbook_perm_error");
                    break;
                case "/updateGuestbook":
                    response.sendRedirect("/updateGuestbook_perm_error");
                    break;
                case "/syslog":
                    response.sendRedirect("/syslog_perm_error");
                    break;
            }
            return false;
        }

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
