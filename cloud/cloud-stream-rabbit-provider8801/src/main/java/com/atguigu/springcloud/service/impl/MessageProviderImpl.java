package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @ClassNameMessageProviderImpl
 * @Description
 * @Author 黄皓
 * @Date2020/7/18 16:51
 **/

@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements MessageProvider {

    @Resource
    private MessageChannel output;//消息发送管道
    @Override
    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("---->serial:"+serial+"<----");
        return null;
    }
}
