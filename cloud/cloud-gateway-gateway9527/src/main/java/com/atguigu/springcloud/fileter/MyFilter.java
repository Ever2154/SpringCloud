package com.atguigu.springcloud.fileter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassNameMyFilter
 * @Description
 * @Author 黄皓
 * @Date2020/7/12 17:02
 **/
@Slf4j
@Component
public class MyFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("=====进入自定义过滤器=====");
        String value=exchange.getRequest().getQueryParams().getFirst("user");
        if(value==null){
            log.info("=====null用户=====");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            return exchange.getResponse().setComplete();
        }
        log.info("=====user:"+value+"=====");
        log.info("=====退出自定义过滤器=====");
        return chain.filter(exchange);
    }
    @Override
    public int getOrder() {
        return 0;
    }
}
