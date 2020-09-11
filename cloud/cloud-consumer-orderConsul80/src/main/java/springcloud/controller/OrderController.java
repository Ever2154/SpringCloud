package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
public class OrderController {
    //private static final String PAYMENT = "http://localhost:8001";
    private static final String PAYMENT = "http://cloud-payment-service";
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consul")
    public String info() {
        return restTemplate.getForObject(PAYMENT + "/payment/consul", String.class);
    }

}