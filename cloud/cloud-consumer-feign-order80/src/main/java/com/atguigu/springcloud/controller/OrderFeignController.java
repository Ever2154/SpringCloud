package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
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
@RequestMapping("/order/feign")
@RestController
public class OrderFeignController {
    @Resource
    PaymentFeignService service;
    @GetMapping("/find/{id}")
    public CommonResult find(@PathVariable("id") int id){
        return service.found(id);
    }
    @GetMapping("/timeOut")
    public void timeOut(){
        service.timeOut();
    }
}
