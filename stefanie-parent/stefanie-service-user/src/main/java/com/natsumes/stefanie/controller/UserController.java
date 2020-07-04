package com.natsumes.stefanie.controller;

import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.UserLoginForm;
import com.natsumes.stefanie.entity.form.UserRegisterForm;
import com.natsumes.stefanie.entity.form.WeChartForm;
import com.natsumes.stefanie.pojo.User;
import com.natsumes.stefanie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.natsumes.stefanie.consts.StefanieConst.CURRENT_USER;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public Response register(@Valid @RequestBody UserRegisterForm userRegisterForm) {

        User user = new User();
        BeanUtils.copyProperties(userRegisterForm, user);

        return userService.register(user);
    }

    @PostMapping("/user/login")
    public Response<User> login(@Valid @RequestBody UserLoginForm userLoginForm, HttpSession session) {

        Response<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

        //设置 Session
        session.setAttribute(CURRENT_USER, userResponseVo.getData());
        log.info("login sessionId = {}", session.getId());
        return userResponseVo;
    }

    @PostMapping("/user/wechart")
    public Response<User> wechart(@Valid @RequestBody WeChartForm userForm, HttpSession session) {

        Response<User> userResponseVo = userService.wxLogin(userForm);

        //设置 Session
        session.setAttribute(CURRENT_USER, userResponseVo.getData());
        log.info("login sessionId = {}", session.getId());
        return userResponseVo;
    }

    @GetMapping("/user")
    public Response<User> login(HttpSession session) {
        log.info("user sessionId = {}", session.getId());
        User user = (User) session.getAttribute(CURRENT_USER);
        return Response.success(user);
    }

    @PostMapping("/user/logout")
    public Response<User> logout(HttpSession session) {
        log.info("logout sessionId = {}", session.getId());

        session.removeAttribute(CURRENT_USER);
        return Response.success();
    }

    @PostMapping("/user/{parentId}")
    public Response blind(@PathVariable Integer parentId,
                          HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return userService.blind(user.getId(), parentId);
    }
}
