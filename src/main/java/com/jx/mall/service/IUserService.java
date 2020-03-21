package com.jx.mall.service;

import com.jx.mall.pojo.User;
import com.jx.mall.vo.ResponseVo;

public interface IUserService {

    /*
     *注册
     */
    ResponseVo<User> register(User user);

    /*
     *登录
     */
    ResponseVo<User> login(String username, String password);


}
