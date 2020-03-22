package com.jx.mall.service.impl;

import com.jx.mall.MallApplicationTests;
import com.jx.mall.enums.ResponseEnum;
import com.jx.mall.enums.RoleEnum;
import com.jx.mall.pojo.User;
import com.jx.mall.service.IUserService;
import com.jx.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    public static final String  USERNAME = "jack";

    public static final String  PASSWORD = "123456";
    @Autowired
    private IUserService userService;

    @Before
    public void register() {
        User user = new User(USERNAME,PASSWORD,"jack@qq.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }

    @Test
    public void login() {
        ResponseVo<User> responseVo = userService.login(USERNAME,PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}