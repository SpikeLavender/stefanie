package com.natsumes.stefanie.mapper;

import com.natsumes.stefanie.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByUid(Integer id);

    Order selectByOrderNo(String orderNo);

    List<Order> selectByUidSet(@Param("uIdSet") Set<Integer> uIdSet);
}