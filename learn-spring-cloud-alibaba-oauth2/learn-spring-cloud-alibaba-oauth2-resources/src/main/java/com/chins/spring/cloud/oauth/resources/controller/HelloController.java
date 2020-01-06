package com.chins.spring.cloud.oauth.resources.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  /***
   * 测试"/"需要的权限
   * @return
   */
  @GetMapping("/")
  public String hello() {

    return "hello, oauth2";
  }
}
