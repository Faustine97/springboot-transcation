import com.ucar.train.test.dto.UserDTO;
import com.ucar.train.test.mapper.UserMapper;
import com.ucar.train.test.vo.Role;
import com.ucar.train.test.vo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ucar.train.test.services.impl.*;
import java.util.List;

public class test2 {
    @Autowired
    private UserMapper userMapper;

    @Test
    public static void main(String[] args) {
        UserServiceImpl impl = new UserServiceImpl();
        List<Role> list = impl.getAllRole();
        List<UserDTO> list1 = impl.getAllUser();
        System.out.println(list1);
    }
}