package com.ucar.train.test.services;

import com.ucar.train.test.dto.UserDTO;
import com.ucar.train.test.vo.Guestbook;
import com.ucar.train.test.vo.Role;
import com.ucar.train.test.vo.User;
import com.ucar.train.test.vo.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    List<UserDTO> getAllUser();

    public boolean checkLogin(String user, String password);

    List<Role> getAllRole();

    List<Guestbook> getAllGuestbook(int start, int count);

    User getUser(String name);
    List<UserInfo> getAllUserInfo();
    List<Guestbook> getUserGuestbooks(String name);
    void updateUser(String name, String pwd, String email, String tel);
}
