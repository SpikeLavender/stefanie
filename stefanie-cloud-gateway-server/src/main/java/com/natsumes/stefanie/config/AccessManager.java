package com.natsumes.stefanie.config;

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
        permitAll.add("/");
        //oauth2服务器
        log.info("requestPath=-------------------------------------------------");
        permitAll.add("/**/oauth/**");
    }

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerWebExchange exchange = authorizationContext.getExchange();
//        if (accessToken == null) {
//            return Mono.just(new AuthorizationDecision(false));
//        }



        String requestPath = exchange.getRequest().getURI().getPath();
        if (permitAll(requestPath)) {
            return Mono.just(new AuthorizationDecision(true));
        }
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
