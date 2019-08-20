package com.ucar.train.test.util;

import com.ucar.train.test.exception.BalanceException;
import com.ucar.train.test.exception.MyException;
import com.ucar.train.test.exception.ProbabilityException;
import com.ucar.train.test.services.AccountService;
import com.ucar.train.test.vo.Account;
import com.ucar.train.test.vo.ConsumingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Service;
import java.sql.Time;
import java.sql.Timestamp;

@Component
public class AccountUtils {

    @Autowired
    AccountService accountService;
    public void reward(int from, int to, float money)
    {

    }

    @Transactional
    public void test(float money)
    {
        Account a = new Account(1, money);
        accountService.updateUserAccount(a);
        throw new MyException();
    }

    @Transactional
    public void reward(Account from, Account to, float money)
    {
        // 余额不足抛出余额不足异常
        if(money>from.getMoney())
        {
            throw new BalanceException();
        }
        // 抛出概率异常
        float fromMoney = from.getMoney()-money;
        from.setMoney(fromMoney);
        float toMoney = to.getMoney()+money;
        to.setMoney(toMoney);

        accountService.updateUserAccount(from);
        int pro = (int)(Math.random()*10);
        if(pro>=5)
        {
            throw new ProbabilityException();
        }
        accountService.updateUserAccount(to);

        //交易完成，插入交易记录
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ConsumingRecord fromRecord = new ConsumingRecord(from.getUserId(),"消费", money, time);
        ConsumingRecord toRecord = new ConsumingRecord(to.getUserId(), "赏金", money,time);
        accountService.addConsumingRecord(fromRecord);
        accountService.addConsumingRecord(toRecord);
    }

}
