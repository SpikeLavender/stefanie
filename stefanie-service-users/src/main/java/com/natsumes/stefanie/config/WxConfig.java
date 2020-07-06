package com.natsumes.stefanie.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wx")
@Data
@RefreshScope
public class WxConfig {
    private String appId;

    private String mchKey;

    private String openIdUrl;
}
