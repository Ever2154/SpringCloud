package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassNamePayment
 * @Description
 * @Author 黄皓
 * @Date2020/6/10 15:39
 **/
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul")
    public String info() {
        return "spring-cloud-consul,port:" + serverPort + UUID.randomUUID();
    }
}
