package com.jx.mall.dao;

import com.jx.mall.MallApplicationTests;
import com.jx.mall.pojo.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class CategoryMapperTest extends MallApplicationTests {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void findById() {
        Category category = categoryMapper.selectByPrimaryKey(100001);
        System.out.println(category.toString());
    }

    @Test
    public void queryById() {
        Category category = categoryMapper.selectByPrimaryKey(100002);
        System.out.println(category);
    }
}