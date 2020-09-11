package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.*;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassNameStreamConsumer8802
 * @Description
 * @Author 黄皓
 * @Date2020/7/18 17:46
 **/
@Component
@EnableBinding(Sink.class)
public class StreamConsumer8802 {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    SubscribableChannel subscribe;


    @StreamListener(Sink.INPUT)
    //TODO 接收不到消息
    public void input(Message<String> msg) {
        System.out.println("serverPort:" + serverPort + ",接收消息:" + msg.getPayload());
    }
}
