package com.natsumes.stefanie.mapper;

import com.natsumes.stefanie.pojo.Users;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    int countById(Integer id);

    int countByUsername(String username);

    int countByOpenid(String openid);

    int countByEmail(String email);

    Users selectByUsername(String username);

    Users selectByOpenid(String openid);

    List<Users> selectByParentId(Integer parentId);

    List<Users> selectAll();
}