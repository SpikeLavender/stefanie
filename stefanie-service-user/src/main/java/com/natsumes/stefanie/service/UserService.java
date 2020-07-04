package com.natsumes.stefanie.service;


import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.WeChartForm;
import com.natsumes.stefanie.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 注册
     *
     * @param user
     * @return
     */
    Response<User> register(User user);

    /**
     * 登录
     */
    Response<User> login(String username, String password);

    /**
     * 登录
     */
    Response<User> wxLogin(WeChartForm weChartForm);

    Response blind(Integer uid, Integer parentId);
}
