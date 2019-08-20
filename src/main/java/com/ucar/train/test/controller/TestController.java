package com.ucar.train.test.controller;

import com.ucar.train.test.exception.BalanceException;
import com.ucar.train.test.exception.MyException;
import com.ucar.train.test.exception.ProbabilityException;
import com.ucar.train.test.function.MyLog;
import com.ucar.train.test.services.AccountService;
import com.ucar.train.test.services.UserService;
import com.ucar.train.test.services.impl.UserHeadService;
import com.ucar.train.test.util.AccountUtils;
import com.ucar.train.test.util.GsonUtils;
import com.ucar.train.test.vo.Account;
import com.ucar.train.test.vo.ConsumingRecord;
import com.ucar.train.test.vo.UserHead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserHeadService userHeadService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountUtils accountUtils;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @RequestMapping("/hello")
    public String say() {
        return driverClassName;
    }


    // @MyLog(value = "测试")
    @RequestMapping("/test")
    public String getAllUser() {
        return userHeadService.getUserHead("Tom").toString();
//        return userService.getAllRole().toString();
        //return GsonUtils.toJson(new Timestamp(System.currentTimeMillis()));
    }

    @RequestMapping("/test2")
    //
    public String test2() {

        return userHeadService.getHistoryHead("Tom").toString();
    }

    @RequestMapping("/account1")
    public String account1()
    {
        // return "account1";
        int money = -1;
        try {
            money = accountService.getUserBalance(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return money+"";
    }

    @RequestMapping("/account2")
    public void account2()
    {
        Account account = new Account(1, 5);
        accountService.updateUserAccount(account);
    }

    @RequestMapping("/account3")
    public String account3()
    {
        ConsumingRecord record = new ConsumingRecord(3,"充值",5,new Timestamp(System.currentTimeMillis()));
        accountService.addConsumingRecord(record);
        return accountService.getConsumingRecord(1).toString();

    }

    //@Transactional(rollbackFor = Exception.class)
    @RequestMapping("/transcation")
    public String transcation()
    {
        Account from = accountService.getUserAccount(1);
        Account to = accountService.getUserAccount(3);

        try {
            accountUtils.reward(from, to,5);
        } catch (BalanceException b) {
            System.out.println("余额不足");
        }catch (ProbabilityException p)
        {
            System.out.println("随机回滚");
        }
        return accountService.getConsumingRecord(from.getUserId()).toString();
    }


}
