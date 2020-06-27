package com.atguigu.springcloud.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Payment 业务逻辑层实现类
 *
 * @author makejava
 * @since 2020-06-05 10:30:28
 */
@Service
//全局降级 方法不能有参数，否则找不到方法
@DefaultProperties(defaultFallback = "globalFallBack")
public class PaymentServiceImpl  {

    /**
     * @description:正常访问，OK
     * @return:
     * @author: 黄皓
     * @time: 2020/6/24 10:22
     */
    public String paymentInfo_OK(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"    paymentInfo_OK,id:"+id+"\tO(∩_∩)O哈哈";
    }

    //@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties ={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")})
    @HystrixCommand
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber=3;
        int a=5/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+",paymentInfo_TimeOut8001,id:"+id+"\t耗时(秒):"+timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id){

        return "线程池:"+Thread.currentThread().getName()+",paymentInfo_TimeOutHandler,id:"+id+"\t/(ㄒoㄒ)/~~";
    }
    public String globalFallBack(){

        return "全局fallback";
    }

    //===服务熔断
    @HystrixCommand(fallbackMethod = "circuitBreakerFallBack",
            commandProperties = {@HystrixProperty(name= "circuitBreaker.enabled",value = "true"),
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "20000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")})
    public String circuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException();
        }
        String str= IdUtil.simpleUUID();
        return "circuitBreaker->"+str;
    }

    public String circuitBreakerFallBack(Integer id){
        return "circuitBreakerFallBack";
    }
}