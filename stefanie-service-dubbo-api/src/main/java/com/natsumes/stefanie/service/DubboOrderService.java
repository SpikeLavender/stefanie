package com.natsumes.stefanie.service;

import com.natsumes.stefanie.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface DubboOrderService {
    int deleteByPrimaryKey(Integer id);

    int insert(Order order);

    int insertSelective(Order order);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order order);

    int updateByPrimaryKey(Order order);

    List<Order> selectByUid(Integer id);

    Order selectByOrderNo(String orderNo);

    List<Order> selectByUidSet(@Param("uIdSet") Set<Integer> uIdSet);
}
