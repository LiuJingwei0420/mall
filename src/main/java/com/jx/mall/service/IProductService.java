package com.jx.mall.service;

import com.github.pagehelper.PageInfo;
import com.jx.mall.vo.ProductDetailVo;
import com.jx.mall.vo.ResponseVo;

public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
