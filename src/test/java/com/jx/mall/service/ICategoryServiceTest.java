package com.jx.mall.service;

import com.jx.mall.MallApplicationTests;
import com.jx.mall.enums.ResponseEnum;
import com.jx.mall.vo.CategoryVo;
import com.jx.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ICategoryServiceTest extends MallApplicationTests {

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void selectAll() {

        ResponseVo<List<CategoryVo>> responseVo = categoryService.selectAll();
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());

    }
}