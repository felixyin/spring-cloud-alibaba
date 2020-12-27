package com.qtrj.scali.config;

import com.alibaba.csp.sentinel.datasource.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SentinelCofig {


    @Bean
    public Converter myConverter() {
        return new JsonFlowRuleListConverter();
    }

}
