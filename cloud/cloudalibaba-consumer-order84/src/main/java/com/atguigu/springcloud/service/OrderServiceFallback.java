package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @ClassNameOrderServiceFallback
 * @Description
 * @Author 黄皓
 * @Date2020/9/10 10:50
 **/
@Component
public class OrderServiceFallback implements OrderService {
    @Override
    public CommonResult<Payment> find(int id) {
        return new CommonResult<>(444,"feign->fallback",null);
    }
}
