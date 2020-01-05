package com.chins.spring.cloud.alibaba.oauth.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chins.spring.cloud.alibaba.oauth.server.domain.User;

public interface UserService extends IService<User> {

  User getUserByUsername(String username);
}
