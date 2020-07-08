package com.natsumes.stefanie.service;


import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.UserRegisterForm;
import com.natsumes.stefanie.pojo.Users;

public interface OauthService {

    Response register(UserRegisterForm userRegisterForm);

    Response<Users> login(String username, String password);

    Response<Users> wxLogin(String userCode);
}
