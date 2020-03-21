package com.jx.mall.service.impl;

import com.jx.mall.dao.UserMapper;
import com.jx.mall.enums.RoleEnum;
import com.jx.mall.pojo.User;
import com.jx.mall.service.IUserService;
import com.jx.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static com.jx.mall.enums.ResponseEnum.*;

@Service
public class UserServiceImpl implements IUserService {
    /*
    注册
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVo register(User user) {
        //username不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if( countByUsername > 0) {
            return ResponseVo.error(USERNAME_EXIST);
        }

        //email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if( countByEmail > 0) {
            return ResponseVo.error(EMAIL_EXIST);
        }

        user.setRole(RoleEnum.CUSTOMER.getCode());

        //MD5摘要算法(Spring自带）
         user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));


        //写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0) {
            return ResponseVo.error(ERROR);
        }

        return ResponseVo.success();
    }
}
