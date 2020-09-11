package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassNameMainPayment9001
 * @Description
 * @Author 黄皓
 * @Date2020/7/20 11:16
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class MainPayment9001 {
    public static void main(String[] args) {
        SpringApplication.run(MainPayment9001.class, args);
    }
}
