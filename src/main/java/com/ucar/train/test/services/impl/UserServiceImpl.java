package com.ucar.train.test.services.impl;

import com.ucar.train.test.dto.UserDTO;
import com.ucar.train.test.mapper.UserMapper;
import com.ucar.train.test.services.UserService;
import com.ucar.train.test.util.JdbcHelper;
import com.ucar.train.test.vo.Role;
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
    public boolean checkLogin(String user, String password)
    {
        try {
            Connection conn = JdbcHelper.getConnection();

            String sql = "select * from `user` where user_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            // 如果查找不到该用户
            if (rs.next() == false) {
                return  false;
            }
            // 如果查找到用户，则比较密码
            else {
                String result = rs.getString("user_password");
//                System.out.println("user_password: "+ result);
                // 密码正确
                if (result.equals(password)) {
                    return true;
                }
                else{
                    return false;
                }
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
            return true;
        }
        finally {
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
    public List<Role> getAllRole()
    {
        return userMapper.getAllRole();
    }
}
