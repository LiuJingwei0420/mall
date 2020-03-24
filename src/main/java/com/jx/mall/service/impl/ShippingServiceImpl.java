package com.jx.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.jx.mall.dao.ShippingMapper;
import com.jx.mall.enums.ResponseEnum;
import com.jx.mall.form.ShippingForm;
import com.jx.mall.pojo.Shipping;
import com.jx.mall.service.IShippingService;
import com.jx.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    @Override
    public ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form, shipping);
        shipping.setUserId(uid);
        int row = shippingMapper.insertSelective(shipping);
        if(row == 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("shippingId", shipping.getId());



        return ResponseVo.success(map);
    }

    @Override
    public ResponseVo delete(Integer uid, Integer shippingId) {
        shippingMapper.deleteByPrimaryKey()
        return null;
    }

    @Override
    public ResponseVo update(Integer uid, Integer shippingId, ShippingForm form) {
        return null;
    }

    @Override
    public ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize) {
        return null;
    }
}
