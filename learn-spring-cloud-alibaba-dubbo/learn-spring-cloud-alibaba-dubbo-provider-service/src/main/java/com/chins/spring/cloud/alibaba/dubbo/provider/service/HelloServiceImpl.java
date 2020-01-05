package com.chins.spring.cloud.alibaba.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.chins.spring.cloud.alibaba.dubbo.provider.api.HelloService;

@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String string) {

        return "Hello Dubbo Provider, " + string;
    }
}
