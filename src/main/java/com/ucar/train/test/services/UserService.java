package com.ucar.train.test.services;

import com.ucar.train.test.dto.UserDTO;
import com.ucar.train.test.vo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    List<UserDTO> getAllUser();

    public boolean checkLogin(String user, String password);

    List<Role> getAllRole();
}
