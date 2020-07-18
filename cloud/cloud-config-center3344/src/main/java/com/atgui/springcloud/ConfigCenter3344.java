package com.atgui.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassNameConfigCenter3344
 * @Description
 * @Author 黄皓
 * @Date2020/7/13 15:15
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344.class,args);
    }
}
