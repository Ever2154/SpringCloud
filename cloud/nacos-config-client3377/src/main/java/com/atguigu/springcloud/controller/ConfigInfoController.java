package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameConfigInfoController
 * @Description
 * @Author 黄皓
 * @Date2020/7/27 9:42
 **/
@RestController
@RefreshScope
public class ConfigInfoController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/nacos/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
