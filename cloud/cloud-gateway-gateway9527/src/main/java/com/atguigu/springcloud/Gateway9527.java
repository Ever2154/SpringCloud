package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @ClassNameGateway9527
 * @Description
 * @Author 黄皓
 * @Date2020/6/28 11:19
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Gateway9527 {
    public static void main(String[] args) {
        SpringApplication.run(Gateway9527.class,args);
    }
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
/*        return builder.routes()
                .route(p->p.path("/get")
                        .filters(f->f.addRequestHeader("Hello","World"))
                        .uri("http://httpbin.org:80"))
                .route(p->p.host("*.hystrix.com")
                        .filters(f->f.hystrix(config -> config.setName("mycmd")))
                        .uri("http://httpbin.org:80"))
                        .build();*/
        return builder.routes().route("route1",r->r.path("/").uri("http://news.baidu.com/guonei")).build();
    }
}
