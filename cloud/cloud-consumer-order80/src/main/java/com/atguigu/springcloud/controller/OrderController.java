package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import com.netflix.discovery.EurekaClient;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * (Payment)控制层
 *
 * @author makejava
 * @since 2020-06-05 10:30:28
 */
@Slf4j
@RestController
@RequestMapping("/order")
@Api("Controller")
public class OrderController {
    //private static final String PAYMENT = "http://localhost:8001";
    private static final String PAYMENT = "http://cloud-payment-service";
    @Resource
    RestTemplate restTemplate;
    @Resource
    LoadBalancer loadBalancer;

    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping("/add")
    public CommonResult<Payment> add(Payment payment) {
        return restTemplate.postForObject(PAYMENT + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping("/find/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT + "/payment/find/" + id, CommonResult.class);
    }

    @GetMapping("/getEntity/{id}")
    public CommonResult<Object> getEntity(@PathVariable("id") Integer id) {

        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT + "/payment/find/" + id, CommonResult.class);

        return new CommonResult<>(entity.getStatusCodeValue(),"msg",entity.getBody().getData());
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        ServiceInstance serviceInstance = loadBalancer.instances(discoveryClient.getInstances("cloud-payment-service"));
        return restTemplate.getForObject(serviceInstance.getUri()+"/payment/lb",String.class);
    }
}