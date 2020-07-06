package com.natsumes.stefanie.service;


import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.WeChartForm;
import com.natsumes.stefanie.pojo.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 注册
     *
     * @param users
     * @return
     */
    Response<Users> register(Users users);

    /**
     * 登录
     */
    Response<Users> login(String username, String password);

    /**
     * 登录
     */
    Response<Users> wxLogin(WeChartForm weChartForm);

    Response blind(Integer uid, Integer parentId);
}
