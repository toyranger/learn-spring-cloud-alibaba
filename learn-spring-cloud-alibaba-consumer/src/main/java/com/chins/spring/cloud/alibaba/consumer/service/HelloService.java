package com.chins.spring.cloud.alibaba.consumer.service;

import com.chins.spring.cloud.alibaba.consumer.fallback.HelloServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-provider", fallback = HelloServiceFallBack.class)
public interface HelloService {

    @GetMapping("/hello/{name}")
    String hello(@PathVariable String name);
}
