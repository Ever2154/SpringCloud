package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassNameMainServer701
 * @Description
 * @Author 黄皓
 * @Date2020/6/8 10:56
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer
public class MainServer7001 {
    public static void main(String[] args) {
        SpringApplication.run(MainServer7001.class, args);
    }
}
