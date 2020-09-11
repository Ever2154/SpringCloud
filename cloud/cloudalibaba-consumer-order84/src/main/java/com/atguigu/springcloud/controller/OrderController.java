package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * (Payment)控制层
 *
 * @author makejava
 * @since 2020-06-05 10:30:28
 */
@Slf4j
@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
@Api("Controller")
public class OrderController {

    private static final String SERVICE_URL="http://cloudalibaba-payment-service";

    @Resource
    private RestTemplate rest;
    @Resource
    private OrderService service;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "fallback")
    public CommonResult find(@PathVariable("id") int id) {
        if(id<1){
            throw new IllegalArgumentException("id不为负");
        }
        return rest.getForObject(SERVICE_URL+"/payment/find/"+id,CommonResult.class);
    }
    //兜底方法 需要id参数
    public CommonResult fallback(@PathVariable("id") int id,Throwable e){
        return new CommonResult<String>(500,"fallback"+e.getMessage(),null);
    }

    @GetMapping("/find/{id}")
    public CommonResult findByFeign(@PathVariable("id") int id) {
        return service.find(id);
    }
}