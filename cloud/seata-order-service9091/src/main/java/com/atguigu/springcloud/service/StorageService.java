package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("storage-service")
public interface StorageService {
    @GetMapping("/storage/deduct")
    void deduct(@RequestParam("code") String code, @RequestParam("count")Integer count);
}
