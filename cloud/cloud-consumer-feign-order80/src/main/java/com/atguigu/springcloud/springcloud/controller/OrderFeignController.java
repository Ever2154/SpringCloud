package com.atguigu.springcloud.springcloud.controller;

import com.atguigu.springcloud.springcloud.entity.CommonResult;
import com.atguigu.springcloud.springcloud.service.PaymentFeignService;
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
@RequestMapping(value = "/order/feign",produces = MediaType.APPLICATION_JSON_VALUE)
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
