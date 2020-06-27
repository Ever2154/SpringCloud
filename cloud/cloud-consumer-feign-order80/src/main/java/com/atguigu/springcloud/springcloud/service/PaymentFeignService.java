package com.atguigu.springcloud.springcloud.service;


import com.atguigu.springcloud.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping("/payment/find/{id}")
    CommonResult found(@PathVariable("id") int id);

    @GetMapping("/payment/timeOut")
    void timeOut();
}
