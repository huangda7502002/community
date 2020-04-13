package life.majiang.community.service;

import life.majiang.community.entity.User;
import life.majiang.community.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class UserServiceTest {


    @Autowired
    private UserServiceImpl userService;

    @Test
    void insert() {
        User user = new User();
        user.setToken(UUID.randomUUID().toString());
        user.setName("111111");
        user.setAccountId("111111");
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        userService.insert(user);
    }
}
