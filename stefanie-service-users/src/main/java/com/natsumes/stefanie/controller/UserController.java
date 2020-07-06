package com.natsumes.stefanie.controller;

import com.natsumes.stefanie.entity.Response;
import com.natsumes.stefanie.entity.form.UserLoginForm;
import com.natsumes.stefanie.entity.form.UserRegisterForm;
import com.natsumes.stefanie.entity.form.WeChartForm;
import com.natsumes.stefanie.pojo.Users;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Response register(@Valid @RequestBody UserRegisterForm userRegisterForm) {

        Users users = new Users();
        BeanUtils.copyProperties(userRegisterForm, users);

        return userService.register(users);
    }

    @PostMapping("/login")
    public Response<Users> login(@Valid @RequestBody UserLoginForm userLoginForm, HttpSession session) {

        Response<Users> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

        //设置 Session
        session.setAttribute(CURRENT_USER, userResponseVo.getData());
        log.info("login sessionId = {}", session.getId());
        return userResponseVo;
    }

    @PostMapping("/wechart")
    public Response<Users> wechart(@Valid @RequestBody WeChartForm userForm, HttpSession session) {

        Response<Users> userResponseVo = userService.wxLogin(userForm);
        return userResponseVo;
    }

    @PostMapping("/{userId}/logout")
    public Response<Users> logout(@PathVariable Integer userId) {
        log.info("logout sessionId = {}", userId);

//        session.removeAttribute(CURRENT_USER);
        return Response.success();
    }

    @PostMapping("/{userId}/{parentId}")
    public Response blind(@PathVariable Integer userId, @PathVariable Integer parentId) {
        return userService.blind(userId, parentId);
    }
}
