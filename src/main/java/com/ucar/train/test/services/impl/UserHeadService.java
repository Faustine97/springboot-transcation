package com.ucar.train.test.services.impl;

import com.ucar.train.test.mapper.UserHeadMapper;
import com.ucar.train.test.vo.UserHead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHeadService {
    @Autowired
    private UserHeadMapper userHeadMapper;


    public void saveHistoryHead(UserHead userHead) {
        userHeadMapper.saveHistoryHead(userHead);
    }

    public void saveUserHead(UserHead userHead) {
        userHeadMapper.deleteUserHead(userHead.getUserName());
        userHeadMapper.saveUserHead(userHead);
    }

    public List<UserHead> getHistoryHead(String userName) {
        return userHeadMapper.getHistoryHead(userName);
    }

    public UserHead getUserHead(String name) {
        return userHeadMapper.getUserHead(name);
    }

}
