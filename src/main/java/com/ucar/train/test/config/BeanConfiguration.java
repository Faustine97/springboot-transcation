package com.ucar.train.test.config;

import com.ucar.train.test.vo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean(name = "user")
    public User getUser()
    {
        User user = new User((long)1,"Tom", "123456");
        return user;
    }
}
