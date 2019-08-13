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
//    void updateUser(String name, String pwd, String email, String tel);
    void updateUser(User user);
    void addRole(String ROLE_NAME, String ROLE_INFO);
    void addRolePerm(String ROLE_NAME, String PERM_NAME);
    boolean deleteRolePerm(String ROLE_NAME, String PERM_NAME);
    void userAddRole(String ROLE_NAME, String USER_NAME);
    List<String> getUserPerm(String name);

}
