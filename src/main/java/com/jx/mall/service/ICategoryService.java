package com.jx.mall.service;

import com.jx.mall.vo.CategoryVo;
import com.jx.mall.vo.ResponseVo;

import java.util.List;

public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();
}
