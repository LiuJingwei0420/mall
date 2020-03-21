package com.jx.mall.service.impl;

import com.jx.mall.MallApplicationTests;
import com.jx.mall.enums.RoleEnum;
import com.jx.mall.pojo.User;
import com.jx.mall.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void register() {
        User user = new User("jack","123456","jack@qq.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }
}