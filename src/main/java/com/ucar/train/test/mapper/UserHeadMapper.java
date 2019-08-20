package com.ucar.train.test.mapper;

import com.ucar.train.test.vo.UserHead;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserHeadMapper {
    void saveHistoryHead(UserHead userHead);

    void saveUserHead(UserHead userHead);

    List<UserHead> getHistoryHead(String userName);

    UserHead getUserHead(String name);

    void deleteUserHead(String name);
}
