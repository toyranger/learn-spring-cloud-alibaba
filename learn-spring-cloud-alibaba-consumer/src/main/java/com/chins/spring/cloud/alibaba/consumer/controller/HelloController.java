package com.chins.spring.cloud.alibaba.consumer.controller;

import com.chins.spring.cloud.alibaba.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {

  @Autowired
  private HelloService helloService;

  @Value("${user.name}")
  private String username;

  @GetMapping("/feign/hello/{name}")
  public String hello(@PathVariable String name) {
    return helloService.hello(name);
  }

  @GetMapping("/feign/echo")
  public String echo() {
    return username;
  }
}
