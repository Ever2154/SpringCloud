package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassNameOrder83Controller
 * @Description
 * @Author 黄皓
 * @Date2020/7/24 17:31
 **/
@RestController
public class Order83Controller {
    @Value("${server.port}")
    private String serverPort;

    @Value("${service-url.nacos-user-service}")
    private String SERVICE_NAME;

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/nacos/order/{id}")
    public String pay(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(SERVICE_NAME + "/nacos/pay/" + id, String.class);
    }
}
