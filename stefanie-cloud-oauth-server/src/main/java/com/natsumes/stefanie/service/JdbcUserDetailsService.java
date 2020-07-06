package com.natsumes.stefanie.service;

import com.natsumes.stefanie.pojo.Users;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class JdbcUserDetailsService implements UserDetailsService {

    //调用用户接口去验证

    @Reference
    private UserApiService userApiService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Users users = userApiService.selectByUsername(s);
        log.info("ssssssssss{}", users.getUsername());

        return new User(users.getUsername(), users.getPassword(), new ArrayList<>());
    }
}