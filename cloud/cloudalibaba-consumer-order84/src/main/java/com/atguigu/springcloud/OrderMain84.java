package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassNamePaymentMain8001
 * @Description
 * @Author 黄皓
 * @Date2020/6/5 10:06
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.springcloud.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class OrderMain84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain84.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getLoadBalance(){
        return new RestTemplate();
    }
}
