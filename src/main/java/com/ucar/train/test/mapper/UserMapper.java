package com.ucar.train.test.mapper;

import com.ucar.train.test.dto.UserDTO;
import com.ucar.train.test.vo.Guestbook;
import com.ucar.train.test.vo.Role;
import com.ucar.train.test.vo.User;
import com.ucar.train.test.vo.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

//@Repository
public interface UserMapper {

    List<UserDTO> getAllUser();

    List<Role> getAllRole();

    List<Guestbook> getAllGuestbook(int start, int count);

    User getUser(String name);

    List<UserInfo> getAllUserInfo();

    List<Guestbook> getUserGuestbooks(String name);

    void updateUser(String name, String pwd, String email, String tel, String name2);
}
