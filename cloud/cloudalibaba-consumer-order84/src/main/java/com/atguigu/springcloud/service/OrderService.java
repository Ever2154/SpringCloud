package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassNameOrderService
 * @Description
 * @Author 黄皓
 * @Date2020/9/10 9:36
 **/
@FeignClient(value = "cloudalibaba-payment-service",fallback = OrderServiceFallback.class)
public interface OrderService {
    @GetMapping("/payment/find/{id}")
    CommonResult<Payment> find(@PathVariable int id);
}
