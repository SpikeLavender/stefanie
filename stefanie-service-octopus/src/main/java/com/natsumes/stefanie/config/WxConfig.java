package com.natsumes.stefanie.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@RefreshScope
@Data
public class WxConfig {
    @Value("${wx.customer.token}")
    private String token;

    @Value("${wx.customer.AESKey}")
    private String AESKey;

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.openIdUrl}")
    private String openIdUrl;

    @Value("${wx.test}")
    private String test;
}
