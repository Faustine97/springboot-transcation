package com.ucar.train.test.services.impl;

import com.ucar.train.test.dto.UserDTO;
import com.ucar.train.test.mapper.UserMapper;
import com.ucar.train.test.services.UserService;
import com.ucar.train.test.util.JdbcHelper;
import com.ucar.train.test.vo.Guestbook;
import com.ucar.train.test.vo.Role;
import com.ucar.train.test.vo.User;
import com.ucar.train.test.vo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.List;

/**
 * @author zhoujinmu
 * @title UserService
 * @projectName test
 * @description TODO
 * @created 2019-08-07 09:11
 **/
@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public boolean checkLogin(String user, String password) {
        try {
            Connection conn = JdbcHelper.getConnection();

            String sql = "select * from `user` where user_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            // 如果查找不到该用户
            if (rs.next() == false) {
                return false;
            }
            // 如果查找到用户，则比较密码
            else {
                String result = rs.getString("user_password");
//                System.out.println("user_password: "+ result);
                // 密码正确
                if (result.equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        } finally {
//            try {
//                rs.close();
//                ps.close();
//                conn.close();
//            }catch (SQLException sql){
//                sql.printStackTrace();
//            }
        }
    }

    @Override
    public List<Role> getAllRole() {
        return userMapper.getAllRole();
    }

    @Override
    public List<Guestbook> getAllGuestbook(int start, int count) {
        return userMapper.getAllGuestbook(start, count);
    }

    @Override
    public User getUser(String name) {
        return userMapper.getUser(name);
    }

    @Override
    public List<UserInfo> getAllUserInfo() {
        return userMapper.getAllUserInfo();
    }

    @Override
    public List<Guestbook> getUserGuestbooks(String name) {
        return userMapper.getUserGuestbooks(name);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void addRole(String ROLE_NAME, String ROLE_INFO){
        userMapper.addRole(ROLE_NAME,ROLE_INFO);
    }
    public void addRolePerm(String ROLE_NAME, String PERM_NAME){
        userMapper.addRolePerm(ROLE_NAME,PERM_NAME);
    }
    public boolean deleteRolePerm(String ROLE_NAME, String PERM_NAME){
       if ( userMapper.deleteRolePerm(ROLE_NAME,PERM_NAME)==0)
       {
           return false;
       }
       else {
           return true;
       }
    }

    public void userAddRole(String ROLE_NAME, String USER_NAME)
    {
        userMapper.userAddRole(ROLE_NAME, USER_NAME);
    }
    public void userDeleteRole(@Param("USER_NAME")String USER_NAME, @Param("ROLE_NAME")String ROLE_NAME)
    {
        userMapper.userDeleteRole(USER_NAME, ROLE_NAME);
    }
    public List<String> getUserPerm(String name)
    {
        return userMapper.getUserPerm(name);
    }

    public List<String> getUserRole(String name)
    {
        return userMapper.getUserRole(name);
    }

    public List<String> getUserGroup(String name)
    {
        return userMapper.getUserGroup(name);
    }
    public void deleteGuestbook(int message_id)
    {
        userMapper.deleteGuestbook(message_id);
    }
    public void updateGuestbook(String message_title, String message_content, Timestamp message_edit_time, int message_id)
    {
        userMapper.updateGuestbook(message_title,message_content,message_edit_time,message_id);
    }
    public void addGuestbook(String message_title, String message_content, Timestamp message_create_time,Timestamp message_edit_time, int user_id)
    {
        userMapper.addGuestbook(message_title,message_content,message_create_time,message_edit_time,user_id);
    }
    public int getAllGuestbooksCount()
    {
        return userMapper.getAllGuestbooksCount();
    }
//    public void updateUser(String user_name, String user_password, String user_email, String user_telephone, int user_id)
//    {
//        userMapper.updateUser(user_name,user_password,user_email,user_telephone,user_id);
//    }

}
