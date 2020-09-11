package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ClassNamePaymentFallBack
 * @Description
 * @Author 黄皓
 * @Date2020/6/24 15:55
 **/
@Component
public class PaymentFallBack implements PaymentFeignService {
    @Override
    public String paymentInfo_OK(int id) {
        return "PaymentFallBack-->paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(int id) {
        return "PaymentFallBack-->paymentInfo_TimeOut";
    }
}
