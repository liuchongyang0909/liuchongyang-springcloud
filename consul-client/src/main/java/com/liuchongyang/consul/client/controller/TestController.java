package com.liuchongyang.consul.client.controller;

import com.liuchongyang.consul.client.config.ConsulConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
    @Value("${config.info}")
    private String configInfo;

    @Autowired
    private ConsulConfigInfo consulConfigInfo;

    @RequestMapping("getConfig")
    public Object getConfig() {
        return configInfo;
    }

    @RequestMapping("getConsulConfigInfo")
    public Object getConsulConfigInfo() {
        return consulConfigInfo;
    }
}
