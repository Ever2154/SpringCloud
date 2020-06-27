package com.atguigu.springcloud.springbloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassNameMainPayment8006
 * @Description
 * @Author 黄皓
 * @Date2020/6/10 15:25
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient//该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class MainPayment8006 {
    public static void main(String[] args) {
        SpringApplication.run(MainPayment8006.class,args);
    }
}
