package com.natsumes.stefanie.service.impl;

import com.natsumes.stefanie.mapper.ShippingMapper;
import com.natsumes.stefanie.mapper.UserMapper;
import com.natsumes.stefanie.pojo.Shipping;
import com.natsumes.stefanie.pojo.Users;
import com.natsumes.stefanie.service.UserApiService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@Service
public class UserApiServiceImpl implements UserApiService {

    @Autowired
    private ShippingMapper shippingMapper;

    @Autowired
    private UserMapper userMapper;

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

    @Override
    public Users selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public Users selectByOpenid(String openid) {
        return userMapper.selectByOpenid(openid);
    }
}
