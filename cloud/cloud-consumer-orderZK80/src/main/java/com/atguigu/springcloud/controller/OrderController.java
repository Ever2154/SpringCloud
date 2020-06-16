package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * (Payment)控制层
 *
 * @author makejava
 * @since 2020-06-05 10:30:28
 */
@Slf4j
@RestController
@RequestMapping("/order")
@Api("Controller")
public class OrderController {
    //private static final String PAYMENT = "http://localhost:8001";
    private static final String PAYMENT = "http://cloud-payment-service";
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/zk")
    public String add() {
        return restTemplate.getForObject(PAYMENT + "/payment/zk", String.class);
    }
}