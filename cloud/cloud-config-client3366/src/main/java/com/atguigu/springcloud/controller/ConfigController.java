package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameConfigController
 * @Description
 * @Author 黄皓
 * @Date2020/7/13 17:43
 **/
@RestController
//需发post请求刷新 curl -X POST "http://localhost:3366/actuator/refresh"
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo(){

        return "port:"+serverPort+",configInfo:"+configInfo;
    }
}
