package com.chins.spring.cloud.alibaba.oauth.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chins.spring.cloud.alibaba.oauth.server.domain.User;
import com.chins.spring.cloud.alibaba.oauth.server.mapper.UserMapper;
import com.chins.spring.cloud.alibaba.oauth.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public User getUserByUsername(String username) {

    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("username", username);

    return userMapper.selectOne(queryWrapper);
  }
}
