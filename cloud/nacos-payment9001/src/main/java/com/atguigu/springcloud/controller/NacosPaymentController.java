package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameNacosPaymentController
 * @Description
 * @Author 黄皓
 * @Date2020/7/20 13:54
 **/
@RestController
public class NacosPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/nacos/pay/{id}")
    public String pay(@PathVariable("id") Integer id){
        return "nacos->Payment9001->port:"+serverPort+"->id:"+id;
    }
}
