package com.ucar.train.test.mapper;

import com.ucar.train.test.dto.UserDTO;
import com.ucar.train.test.vo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<UserDTO> getAllUser();

    List<Role> getAllRole();
}
