package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.MessageProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassNameProviderController
 * @Description
 * @Author 黄皓
 * @Date2020/7/18 17:04
 **/
@RestController
public class ProviderController {

    @Resource
    MessageProvider messageProvider;

    @RequestMapping("/send")
    public String sendMsg(){
        return messageProvider.send();
    }
}
