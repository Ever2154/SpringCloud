package com.atguigu.springcloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @ClassNameHystrixMainPayment8001
 * @Description
 * @Author 黄皓
 * @Date2020/6/24 10:11
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableHystrix
public class HystrixMainPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMainPayment8001.class,args);
    }
}
