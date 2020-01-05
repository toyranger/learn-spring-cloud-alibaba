package com.chins.spring.cloud.alibaba.oauth.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.chins.spring.cloud.alibaba.oauth.server.mapper")
public class OAuth2AuthenAndAuthorApplication {

  public static void main(String[] args) {
    SpringApplication.run(OAuth2AuthenAndAuthorApplication.class, args);
  }
}
