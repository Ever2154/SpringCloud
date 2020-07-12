package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;

import java.util.concurrent.TimeUnit;

/**
 * (Payment)控制层
 *
 * @author makejava
 * @since 2020-06-05 10:30:28
 */
@Slf4j
@RestController
@RequestMapping("/payment")
@Api("Controller")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/add")
    public CommonResult add(@RequestBody Payment payment) {
        int i = paymentService.add(payment);
        log.info("插入结果" + payment+",端口号:"+serverPort);
        if (i > 0) {
            log.info("插入成功");
            return new CommonResult(200, "插入成功", i);
        } else {
            log.info("插入失败");
            return new CommonResult(401, "插入失败");
        }
    }

    @GetMapping("/find/{id}")
    public CommonResult find(@PathVariable("id") int id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询" + id+",端口号:"+serverPort);
        if (payment != null) {
            log.info("查询成功");
            return new CommonResult(200, "查询成功"+",端口号:"+serverPort, payment);
        } else {
            log.info("查询失败");
            return new CommonResult(401, "未查到 id:" + id);
        }
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/timeOut")
    public void timeOut() {

        try{
            TimeUnit.SECONDS.sleep(3);
            System.out.println("延时3秒");
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}