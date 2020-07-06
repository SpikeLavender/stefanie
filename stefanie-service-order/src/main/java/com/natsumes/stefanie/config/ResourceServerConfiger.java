package com.natsumes.stefanie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer  // 开启资源服务器功能
@EnableWebSecurity  // 开启web访问安全
public class ResourceServerConfiger extends ResourceServerConfigurerAdapter {

    @Value("${sign_key}")
    private String signKey;

    @Autowired
    private StefanieAccessTokenConverter stefanieAccessTokenConverter;

    /**
     * 该方法用于定义资源服务器向远程认证服务器发起请求，进行token校验等事宜
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
        resources.resourceId("order").tokenStore(tokenStore()).stateless(true);
    }

    /**
     * 场景：一个服务中可能有很多资源（API接口）
     *    某一些API接口，需要先认证，才能访问
     *    某一些API接口，压根就不需要认证，本来就是对外开放的接口
     *    我们就需要对不同特点的接口区分对待（在当前configure方法中完成），设置是否需要经过认证
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)   // 设置session的创建策略（根据需要创建即可）
                .and()
                .authorizeRequests()
                ;  //  其他请求不认证
    }

    /*
       该方法用于创建tokenStore对象（令牌存储对象）
       token以什么形式存储
    */
    public TokenStore tokenStore(){
        //return new InMemoryTokenStore();

        // 使用jwt令牌
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * 返回jwt令牌转换器（帮助我们生成jwt令牌的）
     * 在这里，我们可以把签名密钥传递进去给转换器对象
     * @return
     */
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(signKey);  // 签名密钥
        jwtAccessTokenConverter.setVerifier(new MacSigner(signKey));  // 验证时使用的密钥，和签名密钥保持一致
        jwtAccessTokenConverter.setAccessTokenConverter(stefanieAccessTokenConverter);
        return jwtAccessTokenConverter;
    }

}
