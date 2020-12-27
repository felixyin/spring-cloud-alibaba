package com.qtrj.scali.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class NacosConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    /**
     * 负载均衡测试
     * @param id
     * @return
     * @link http://localhost:81/consumer/payment/nacos/33
     */
    @GetMapping("/consumer/payment/nacos/{id}")
    public String getPaymentInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, String.class);
    }

}
