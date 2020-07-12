package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.impl.PaymentServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * (Payment)控制层
 *
 * @author makejava
 * @since 2020-06-05 10:30:28
 */
@Slf4j
@RestController
//@RequestMapping("/payment")
@Api("Controller")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl service;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result=service.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/hystrix/out/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result=service.paymentInfo_TimeOut(id);
        return result;
    }
    @GetMapping("/hystrix/break/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id){
        String result=service.circuitBreaker(id);
        return result;
    }
}