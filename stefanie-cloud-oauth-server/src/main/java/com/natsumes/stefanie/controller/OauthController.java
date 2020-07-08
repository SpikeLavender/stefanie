package com.natsumes.stefanie.controller;

import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.UserLoginForm;
import com.natsumes.stefanie.entity.form.UserRegisterForm;
import com.natsumes.stefanie.entity.form.WeChartForm;
import com.natsumes.stefanie.pojo.Users;
import com.natsumes.stefanie.service.DubboUsersService;
import com.natsumes.stefanie.service.OauthService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.natsumes.stefanie.consts.StefanieConst.CURRENT_USER;

@RequestMapping("/oauth")
@Slf4j
public class OauthController {

    @Autowired
    private OauthService oauthService;

    @PostMapping("/register")
    public Response register(@Valid @RequestBody UserRegisterForm userRegisterForm) {

        return oauthService.register(userRegisterForm);
    }

    @PostMapping("/login")
    public Response<Users> login(@Valid @RequestBody UserLoginForm userLoginForm, HttpSession session) {

        Response<Users> userResponseVo = oauthService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

        //设置 Session
        session.setAttribute(CURRENT_USER, userResponseVo.getData());
        log.info("login sessionId = {}", session.getId());
        return userResponseVo;
    }

    @PostMapping("/wechart")
    public Response<Users> wechart(@Valid @RequestBody WeChartForm userForm) {

        return oauthService.wxLogin(userForm.getUserCode());
    }

    @PostMapping("/{userId}/logout")
    public Response<Users> logout(@PathVariable Integer userId) {
        log.info("logout sessionId = {}", userId);

//        session.removeAttribute(CURRENT_USER);
        return Response.success();
    }

}
