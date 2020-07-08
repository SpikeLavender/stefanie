package com.natsumes.stefanie.config;

import com.natsumes.stefanie.enums.GrantTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class AccessManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    private final Set<String> permitAll = new HashSet<>();

    private static final AntPathMatcher antPathMatcher = new AntPathMatcher();

    public AccessManager() {

//        "/oauth/**", "/pay/**",
//                "/octopus/**", "/logistics/**", "/actuator/**"
        permitAll.add("/");
        //oauth2服务器
        permitAll.add("/oauth/**");

        permitAll.add("/pay/**");

        permitAll.add("/octopus/**");

        permitAll.add("/logistics/**");

        permitAll.add("/actuator/**");
        //开放登陆和注册接口
//        permitAll.add("/user/user/register");
//        permitAll.add("/wxchart/**");
//        permitAll.add("/logistics/**");
//        permitAll.add("/pay/**");
    }

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {

        log.info("authenticate start 授权");

        ServerWebExchange exchange = authorizationContext.getExchange();
//        if (accessToken == null) {
//            return Mono.just(new AuthorizationDecision(false));
//        }

        //登陆接口的话，加一个返回用户信息

        String requestPath = exchange.getRequest().getURI().getPath();
        //如果是登陆获取token
//        if (antPathMatcher.match("/oauth/token", requestPath)) {
//            MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
//            String grant_type = queryParams.getFirst("grant_type");
////            if (GrantTypeEnum.WX.getType().equalsIgnoreCase(grant_type)) {
////                //获取openId并放到username和password上
////                String user_code = queryParams.getFirst("user_code");
////                mono.doOnRequest(k->{}).then().doOnRequest()
////            }
//            List<String> grant_type1 = queryParams.get("grant_type");
//            //queryParams.get("grant_type").add(0, "password");
//        }
        if (permitAll(requestPath)) {
            return Mono.just(new AuthorizationDecision(true));
        }
        //获取微信授权码
        return mono.map(auth -> new AuthorizationDecision(checkAuthorities(auth, requestPath)))
                .defaultIfEmpty(new AuthorizationDecision(false));
    }


    /**
     * 校验是否属于静态资源
     *
     * @param requestPath 请求路径
     * @return
     */
    private boolean permitAll(String requestPath) {
        return permitAll.stream().anyMatch(r -> antPathMatcher.match(r, requestPath));
    }

    /**
     * 权限校验
     *
     * @param auth        Authentication
     * @param requestPath 请求路径
     * @return
     */
    private boolean checkAuthorities(Authentication auth, String requestPath) {
        if (auth instanceof OAuth2Authentication) {
            log.info("requestPath={}", requestPath);
            OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) auth;
            String clientId = oAuth2Authentication.getOAuth2Request().getClientId();
            log.info("clientId is {}", clientId);
            //TODO 记录调用记录
        }
        log.info("requestPath={}", requestPath);
        return true;
    }
}
