package com.natsumes.stefanie.mapper;

import com.natsumes.stefanie.pojo.Achievement;

public interface AchievementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Achievement record);

    int insertSelective(Achievement record);

    Achievement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Achievement record);

    int updateByPrimaryKey(Achievement record);
}