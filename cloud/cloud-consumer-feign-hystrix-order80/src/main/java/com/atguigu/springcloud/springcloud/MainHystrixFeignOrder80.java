package com.atguigu.springcloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassNameMainHystrixFeignOrder80
 * @Description
 * @Author 黄皓
 * @Date2020/6/24 11:17
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableHystrix

public class MainHystrixFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MainHystrixFeignOrder80.class,args);
    }
}
