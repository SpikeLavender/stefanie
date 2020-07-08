package com.natsumes.stefanie.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;


@Component
@Slf4j
public class AuthorizationFilter implements WebFilter, Ordered {

    public AuthorizationFilter() {

    }

    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {

        serverWebExchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
        RequestPath path = serverWebExchange.getRequest().getPath();
        //order(0)最早的
        ServerHttpRequest mutatedRequest = serverWebExchange.getRequest().mutate().build();
        ServerWebExchange mutatedExchange = serverWebExchange.mutate().request(mutatedRequest).build();
        return webFilterChain.filter(mutatedExchange).then(Mono.fromRunnable(()-> {
            Long startTime = serverWebExchange.getAttribute(REQUEST_TIME_BEGIN);
            if (startTime != null) {
                log.info(serverWebExchange.getRequest().getURI().getRawPath() + ": " + (System.currentTimeMillis() - startTime) + "ms");
            }
        }));
    }

    @Override
    public int getOrder() {
        return -100;
    }

}
