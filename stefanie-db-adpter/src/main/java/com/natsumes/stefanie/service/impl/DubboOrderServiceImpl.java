package com.natsumes.stefanie.service.impl;

import com.natsumes.stefanie.mapper.OrderMapper;
import com.natsumes.stefanie.pojo.Order;
import com.natsumes.stefanie.service.DubboOrderService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@Service
public class DubboOrderServiceImpl implements DubboOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int insertSelective(Order order) {
        return orderMapper.insertSelective(order);
    }

    @Override
    public Order selectByPrimaryKey(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int updateByPrimaryKey(Order order) {
        return orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public List<Order> selectByUid(Integer id) {
        return orderMapper.selectByUid(id);
    }

    @Override
    public Order selectByOrderNo(String orderNo) {
        return orderMapper.selectByOrderNo(orderNo);
    }

    @Override
    public List<Order> selectByUidSet(Set<Integer> uIdSet) {
        return orderMapper.selectByUidSet(uIdSet);
    }
}
