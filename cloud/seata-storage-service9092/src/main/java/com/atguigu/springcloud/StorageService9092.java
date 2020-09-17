package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassNameStorageService9092
 * @Description
 * @Author 黄皓
 * @Date2020/9/13 17:42
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.atguigu.springcloud.mapper"})
@EnableFeignClients
@EnableDiscoveryClient
public class StorageService9092 {
    public static void main(String[] args) {
        SpringApplication.run(StorageService9092.class,args);
    }
}
