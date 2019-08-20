package com.ucar.train.test.controller;

import com.ucar.train.test.services.AccountService;
import com.ucar.train.test.util.AccountUtils;
import com.ucar.train.test.vo.Account;
import com.ucar.train.test.vo.ConsumingRecord;
import com.ucar.train.test.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/consuming_record")
    public String consumingRecord(HttpSession session)
    {
        User user = (User)session.getAttribute("User");
        int userId = user.getUser_id();
        List<ConsumingRecord> list = accountService.getConsumingRecord(userId);
        session.setAttribute("consuming_record", list);
        return "consuming_record";
    }
    @RequestMapping("/charge")
    public void charge(HttpServletRequest request, HttpServletResponse response)
    {
        String strMoney = request.getParameter("money");
        HttpSession session  = request.getSession();
        try {
            float money = Float.parseFloat(strMoney);
            Account account = (Account) session.getAttribute("user_account");
            float afterMoney = money+account.getMoney();
            System.out.println("afterMoney: " + afterMoney);
            account.setMoney(afterMoney);
            accountService.updateUserAccount(account);
            try {
                response.sendRedirect("/user_edit");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
