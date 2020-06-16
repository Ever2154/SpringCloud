package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.mapper.PaymentMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * Payment 业务逻辑层实现类
 *
 * @author makejava
 * @since 2020-06-05 10:30:28
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

    public int add(Payment payment) {

        save(payment);
        return payment.getId();
    }

    public Payment getPaymentById(int id) {
        return getById(id);
    }
}