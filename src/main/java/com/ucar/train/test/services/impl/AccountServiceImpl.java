package com.ucar.train.test.services.impl;

import com.ucar.train.test.mapper.AccountMapper;
import com.ucar.train.test.services.AccountService;
import com.ucar.train.test.vo.Account;
import com.ucar.train.test.vo.ConsumingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    public Integer getUserBalance(int userId)
    {
        return accountMapper.getUserBalance(userId);
    }
   // @Transactional
    public void updateUserAccount(Account account)
    {
        accountMapper.updateUserAccount(account);
    }
  //  @Transactional
    public void addConsumingRecord(ConsumingRecord record)
    {
        accountMapper.addConsumingRecord(record);
    }

    public List<ConsumingRecord> getConsumingRecord(int userId)
    {
        return accountMapper.getConsumingRecord(userId);
    }

    public Account getUserAccount(int userId)
    {
        return accountMapper.getUserAccount(userId);
    }
}
