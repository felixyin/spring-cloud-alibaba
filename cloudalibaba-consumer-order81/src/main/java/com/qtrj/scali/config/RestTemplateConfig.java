package com.qtrj.scali.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateConfig {
    //Instantiate RestTemplate Instance
    @Bean
    @LoadBalanced // alibaba集成了ribbon，需要标注开启负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
