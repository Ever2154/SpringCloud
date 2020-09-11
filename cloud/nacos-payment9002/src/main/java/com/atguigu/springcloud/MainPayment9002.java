package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassNameMainPayment9002
 * @Description
 * @Author 黄皓
 * @Date2020/7/24 17:20
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class MainPayment9002 {
    public static void main(String[] args) {
        SpringApplication.run(MainPayment9002.class, args);
    }
}
