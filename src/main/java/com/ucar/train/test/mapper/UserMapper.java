package com.ucar.train.test.mapper;

import com.ucar.train.test.dto.UserDTO;
import com.ucar.train.test.vo.Guestbook;
import com.ucar.train.test.vo.Role;
import com.ucar.train.test.vo.User;
import com.ucar.train.test.vo.UserInfo;
import org.apache.ibatis.annotations.Param;
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
    void updateUser(User user);
    //void updateUser(@Param("user_name") String name, @Param("user_password") String pwd, @Param("user_email") String email, @Param("user_telephone") String tel,@Param("user_name2") String name2);
    void addRole(String ROLE_NAME, String ROLE_INFO);
    void addRolePerm(String ROLE_NAME, String PERM_NAME);
    int deleteRolePerm(String ROLE_NAME, String PERM_NAME);
    void userAddRole(String ROLE_NAME,String USER_NAME);

    List<String> getUserPerm(String name);
}
