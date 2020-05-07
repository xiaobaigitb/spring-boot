package com.demo.springboot;

import com.demo.springboot.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot06SonsumerApplicationTests {

    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        userService.hello();
    }

}
