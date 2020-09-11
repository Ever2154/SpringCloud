package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassNamePaymentMain8001
 * @Description
 * @Author 黄皓
 * @Date2020/6/5 10:06
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.springcloud.mapper")
@EnableDiscoveryClient
public class PaymentMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9003.class, args);
    }
}
