package com.chins.spring.cloud.alibaba.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chins.spring.cloud.alibaba.dubbo.provider.api.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboHelloController {

    @Reference(version = "1.0.0")
    private HelloService helloService;

    @GetMapping("/hello/dubbo/{name}")
    public String hello(@PathVariable String name) {

        return helloService.hello(name);
    }
}
