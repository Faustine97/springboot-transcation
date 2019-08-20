package com.ucar.train.test.services;

import com.ucar.train.test.vo.Account;
import com.ucar.train.test.vo.ConsumingRecord;

import java.util.List;

public interface AccountService {
    Integer getUserBalance(int userId);
    void updateUserAccount(Account account);
    void addConsumingRecord(ConsumingRecord record);
    List<ConsumingRecord> getConsumingRecord(int userId);
    Account getUserAccount(int userId);
}
