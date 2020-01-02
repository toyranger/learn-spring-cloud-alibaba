package com.chins.spring.cloud.alibaba.consumer.controller;

import com.chins.spring.cloud.alibaba.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/feign/hello/{name}")
    public String hello(@PathVariable String name) {
        return helloService.hello(name);
    }
}
