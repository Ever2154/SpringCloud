package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping("/payment/find/{id}")
    CommonResult found(@PathVariable("id") int id);

    @GetMapping("/payment/timeOut")
    void timeOut();
}
