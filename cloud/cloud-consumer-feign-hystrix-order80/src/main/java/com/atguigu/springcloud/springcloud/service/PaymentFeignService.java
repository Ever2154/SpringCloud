package com.atguigu.springcloud.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-hystrix-payment",fallback =PaymentFallBack.class)
public interface PaymentFeignService {
    @GetMapping("/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") int id);

    @GetMapping("/hystrix/out/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") int id);
}
