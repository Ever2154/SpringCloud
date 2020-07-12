package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassNamePaymentMain8001
 * @Description
 * @Author 黄皓
 * @Date2020/6/5 10:06
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.springcloud.mapper")
@EnableEurekaClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
