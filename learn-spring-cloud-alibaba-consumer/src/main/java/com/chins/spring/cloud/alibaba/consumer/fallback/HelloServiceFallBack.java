package com.chins.spring.cloud.alibaba.consumer.fallback;

import com.chins.spring.cloud.alibaba.consumer.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallBack implements HelloService {

  @Override
  public String hello(String name) {
    return "你的网络有问题";
  }
}
