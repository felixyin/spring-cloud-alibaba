package com.qtrj.scali.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 支持nacos的动态刷新
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    /**
     * 配置中心测试
     *
     * @return
     * @link http://localhost:3377/config/info
     */
    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
