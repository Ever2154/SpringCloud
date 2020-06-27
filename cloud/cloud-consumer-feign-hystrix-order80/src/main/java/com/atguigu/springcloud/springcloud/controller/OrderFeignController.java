package com.atguigu.springcloud.springcloud.controller;

import com.atguigu.springcloud.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassNameOrderFeignController
 * @Description
 * @Author 黄皓
 * @Date2020/6/15 16:11
 **/
//本是返回xml，设置produces设置返回json
@RequestMapping(value = "/order",produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class OrderFeignController {
    @Resource
    PaymentFeignService service;
    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result=service.paymentInfo_OK(id);
        return result;
    }
    @GetMapping("/hystrix/out/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties ={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")})
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result=service.paymentInfo_TimeOut(id);
        return result;
    }
    public String paymentInfo_TimeOutHandler(Integer id){

        return "线程池:"+Thread.currentThread().getName()+",order80崩溃,id:"+id+"\t/(ㄒoㄒ)/~~";
    }
}
