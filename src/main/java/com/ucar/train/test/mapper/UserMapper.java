package com.ucar.train.test.mapper;

import com.ucar.train.test.dto.UserDTO;
import com.ucar.train.test.vo.*;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.sql.Timestamp;
import java.util.List;


public interface UserMapper {

    List<UserDTO> getAllUser();

    List<Role> getAllRole();

    List<Guestbook> getAllGuestbook(int start, int count);

    User getUser(String name);

    List<UserInfo> getAllUserInfo();

    List<Guestbook> getUserGuestbooks(String name);
    void updateUser(User user);
    //void updateUser(@Param("user_name") String name, @Param("user_password") String pwd, @Param("user_email") String email, @Param("user_telephone") String tel,@Param("user_name2") String name2);
    void addRole(String ROLE_NAME, String ROLE_INFO);
    void deleteRole(String ROLE_NAME);
    void addRolePerm(String ROLE_NAME, String PERM_NAME);
    int deleteRolePerm(String ROLE_NAME, String PERM_NAME);
    void userAddRole(String ROLE_NAME,String USER_NAME);
    void userDeleteRole(String USER_NAME,String ROLE_NAME);
    List<String> getUserRole(String name);
    List<String> getUserPerm(String name);
    List<String> getUserGroup(String name);
    void deleteGuestbook(int message_id);
//    void updateUser(String user_name, String user_password, String user_email, String user_telephone, int user_id);
    void updateGuestbook(String message_title, String message_content, Timestamp message_edit_time, int message_id);
    void addGuestbook(String message_title, String message_content, Timestamp message_create_time,Timestamp message_edit_time, int user_id);
    int getAllGuestbooksCount();

    void addSyslog(SysLog sysLog);
    List<SysLog> selSyslog(int start, int count);
    int getAllSyslogsCount();
    List<SysLog> selSyslogWithOperation(String operation);
}
