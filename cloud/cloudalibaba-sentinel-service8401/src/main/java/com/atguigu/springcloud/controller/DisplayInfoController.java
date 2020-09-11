package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassNameDisplayInfoController
 * @Description
 * @Author 黄皓
 * @Date2020/8/31 17:00
 **/
@RestController
@Slf4j
public class DisplayInfoController {
    @Autowired
    private ApplicationContext applicationContext;
    static Integer a = 0;
    @Value("${server.error.path:${error.path:/error}}")
    String str;

    @GetMapping("/testA")
    public String testA() {
        log.info(Thread.currentThread().getName() + "--->请求");
/*        try{
            //时间设置长点才有效果
            TimeUnit.MILLISECONDS.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }*/
        return "====>test:A";
    }

    @GetMapping("/testB")
    public String testB() {
        return "====>test:B";
    }

    //慢调用比例
    @GetMapping("/testC")
    public String testC() {
        log.info(Thread.currentThread().getName() + "--->请求");
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "====>test:C";
    }

    //异常比例/异常数
    @GetMapping(value = "/testD", produces = MediaType.TEXT_HTML_VALUE)
    public String testD() {
        log.info(Thread.currentThread().getName() + "--->请求");
        System.out.println(str);
        int a=10/0;
        BasicErrorController bean = applicationContext.getBean(BasicErrorController.class);
        System.out.println(bean);
        return "====>test:D";

    }
    //热点规则
    @GetMapping("/testE")
    @SentinelResource(value = "testE",blockHandler = "blockHandlerD")
    public String testE(String p1,String p2) {
        return "====>test:E";
    }

    public String blockHandlerD(String p1, String p2, BlockException e){
        return "blockHandler->D";
    }
}
