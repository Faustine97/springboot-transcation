package com.ucar.train.test.services;

import com.ucar.train.test.dto.UserDTO;
import com.ucar.train.test.vo.Guestbook;
import com.ucar.train.test.vo.Role;
import com.ucar.train.test.vo.User;
import com.ucar.train.test.vo.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
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
    List<String> getUserRole(String name);
    List<String> getUserGroup(String name);
    void deleteGuestbook(int message_id);
    void updateGuestbook(String message_title, String message_content, Timestamp message_edit_time, int message_id);
    void addGuestbook(String message_title, String message_content, Timestamp message_create_time,Timestamp message_edit_time, int user_id);
//    void updateUser(String user_name, String user_password, String user_email, String user_telephone, int user_id);
}
