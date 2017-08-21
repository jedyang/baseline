package org.seckill.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Result;
import org.seckill.entity.User;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void testCountRecord(){
        System.out.println(userService.countRecord("123", "name"));
        System.out.println(userService.countRecord("helloyunsheng@126.com", "email"));
    }
    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setId(1008);
        user.setPassword("1008");
        userService.updateUser(user);
        Result<User> byId = userService.getById("1008");
        System.out.println(byId.getResultObj());
    }

}