package com.natsumes.stefanie.mapper;

import com.natsumes.stefanie.pojo.PayInfo;

public interface PayInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayInfo payInfo);

    int insertSelective(PayInfo payInfo);

    PayInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayInfo payInfo);

    int updateByPrimaryKey(PayInfo payInfo);

    PayInfo selectByByOrderNo(String orderNo);
}
