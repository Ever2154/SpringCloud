package com.atguigu.springcloud.springcloud.service;

import com.atguigu.springcloud.springcloud.entity.Payment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Payment业务逻辑层
 *
 * @author makejava
 * @since 2020-06-05 10:30:28
 */
public interface PaymentService extends IService<Payment> {
    int add(Payment payment);

    Payment getPaymentById(int id);
}