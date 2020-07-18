package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Payment)控制层
 *
 * @author makejava
 * @since 2020-06-05 10:30:28
 */
@Slf4j
@RestController
@RequestMapping(value="/payment",produces = MediaType.APPLICATION_JSON_VALUE)
@Api("Controller")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private EurekaClient eurekaClient;
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

    @GetMapping("/discovery")
    public DiscoveryClient discover(){

        //方法一
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);
        //方法二
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.stream().forEach(obj->{
            System.out.println("obj->host:"+obj.getHost());
            System.out.println("obj->instanceId:"+obj.getInstanceId());
            System.out.println("obj->port:"+obj.getPort());
            System.out.println("obj->host:"+obj.getHost());
            System.out.println("obj->serviceId:"+obj.getServiceId());
            System.out.println("obj->uri:"+obj.getUri());
            System.out.println("obj->schema:"+obj.getScheme());
            System.out.println();
        });
        return discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}