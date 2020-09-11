package com.atguigu.extra;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassNameMyConfiguration
 * @Description
 * @Author 黄皓
 * @Date2020/6/12 11:36
 **/
//@Configuration
public class MySelfRule {
    @Bean
    IRule myRule() {
        return new RandomRule();
    }
}
