package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassNameMainFeignOrder80
 * @Description
 * @Author 黄皓
 * @Date2020/6/15 15:52
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
public class MainFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MainFeignOrder80.class,args);
    }
}
