package com.natsumes.stefanie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.ShippingForm;
import com.natsumes.stefanie.enums.ResponseEnum;
import com.natsumes.stefanie.mapper.ShippingMapper;
import com.natsumes.stefanie.pojo.Shipping;
import com.natsumes.stefanie.service.ShippingApiService;
import com.natsumes.stefanie.service.ShippingService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ShippingServiceImpl implements ShippingService, ShippingApiService {

    @Autowired
    private ShippingMapper shippingMapper;

    @Override
    public Response<Map<String, Integer>> add(Integer uId, ShippingForm form) {

        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form, shipping);
        shipping.setUserId(uId);
        shipping.setIsDefault(Boolean.TRUE);

        int row = shippingMapper.insertSelective(shipping);

        if (row <= 0) {
            return Response.error(ResponseEnum.SYSTEM_ERROR);
        }

        List<Shipping> shippings = shippingMapper.selectByUid(uId).stream()
                .filter(e -> e.getIsDefault() && !e.getId().equals(shipping.getId()))
                .peek(e -> e.setIsDefault(Boolean.FALSE)).collect(Collectors.toList());

        if (!shippings.isEmpty() && shippingMapper.updateBatch(shippings) != shippings.size() * 2) {
            return Response.error(ResponseEnum.SYSTEM_ERROR);
        }
        //判断是否为默认，是的话更新其他的为false
        Map<String, Integer> map = new HashMap<>();
        map.put("shippingId", shipping.getId());
        return Response.success(map);
    }


    //todo:软删除
    @Override
    public Response delete(Integer uId, Integer shippingId) {
        int row = shippingMapper.deleteByIdAndUid(uId, shippingId);
        if (row == 0) {
            return Response.error(ResponseEnum.DELETE_SHIPPING_FAIL);
        }
        return Response.success();
    }

    @Override
    public Response update(Integer uId, Integer shippingId, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form, shipping);
        shipping.setUserId(uId);
        shipping.setId(shippingId);

        List<Shipping> shippings = new ArrayList<>();

        if (form.getIsDefault()) {
            shippings = shippingMapper.selectByUid(uId).stream()
                    .filter(e -> e.getIsDefault() && !e.getId().equals(shippingId))
                    .peek(e -> e.setIsDefault(Boolean.FALSE))
                    .collect(Collectors.toList());
        }

        shippings.add(shipping);

        int row = shippingMapper.updateBatch(shippings);
        if (row <= shippings.size()) {
            return Response.error(ResponseEnum.SYSTEM_ERROR);
        }
        return Response.success();
    }

    @Override
    public Response<PageInfo> list(Integer uId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shipping> shippings = shippingMapper.selectByUid(uId);
        PageInfo<Shipping> pageInfo = new PageInfo<>(shippings);
        return Response.success(pageInfo);
    }

    @Override
    public Shipping selectByUidAndShippingId(Integer uId, Integer shippingId) {
        return shippingMapper.selectByUidAndShippingId(uId, shippingId);
    }

    @Override
    public List<Shipping> selectShippingByIdSet(Set<Integer> shippingIdSet) {
        return shippingMapper.selectByIdSet(shippingIdSet);
    }

    @Override
    public Shipping selectByPrimaryKey(Integer shippingId) {
        return shippingMapper.selectByPrimaryKey(shippingId);
    }
}
