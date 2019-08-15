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

    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取User来验证登陆。
        HttpSession session = request.getSession();
//        这里的User是登陆时放入session的

        List<String> perms = (List<String>)session.getAttribute("perms");

        String perm = request.getServletPath();

        if(perms!=null && perms.contains(perm))
            return true;
        else{
            switch (perm)
            {
                case "/admin" : response.sendRedirect("/admin_perm_error");break;
                case "/user_edit" : response.sendRedirect("/user_edit_perm_error");break;
                case "/user_info" : response.sendRedirect("/user_info_perm_error");break;
                case "/message_create" : response.sendRedirect("/message_create_perm_error");break;
                case "/deleteGuestbook" : response.sendRedirect("/deleteGuestbook_perm_error");break;
                case "/updateGuestbook" : response.sendRedirect("/updateGuestbook_perm_error");break;
            }
            return false;
        }

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
