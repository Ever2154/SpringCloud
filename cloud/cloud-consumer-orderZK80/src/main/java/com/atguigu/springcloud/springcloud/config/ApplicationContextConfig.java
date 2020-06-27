package com.atguigu.springcloud.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassNameApplicationContextConfig
 * @Description
 * @Author 黄皓
 * @Date2020/6/5 14:08
 **/
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
