package com.ucar.train.test.services.impl;

import com.ucar.train.test.dto.UserDTO;
import com.ucar.train.test.mapper.UserMapper;
import com.ucar.train.test.services.UserService;
import com.ucar.train.test.util.JdbcHelper;
import com.ucar.train.test.vo.Guestbook;
import com.ucar.train.test.vo.Role;
import com.ucar.train.test.vo.User;
import com.ucar.train.test.vo.UserInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public List<String> getUserPerm(String name)
    {
        return userMapper.getUserPerm(name);
    }


//    public void updateUser(String name, String pwd, String email, String tel)
//    {
//        userMapper.updateUser(name, pwd, email, tel, name);
////        if()
////        {
////            return true;
////        }
////        else {
////            return false;
////        }
//    }
}
