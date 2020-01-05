package com.chins.spring.cloud.alibaba.oauth.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chins.spring.cloud.alibaba.oauth.server.domain.Permission;
import com.chins.spring.cloud.alibaba.oauth.server.mapper.PermissionMapper;
import com.chins.spring.cloud.alibaba.oauth.server.service.PermissionService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements
    PermissionService {

  @Resource
  private PermissionMapper permissionMapper;

  @Override
  public List<Permission> selectByUserId(Long userId) {
    return permissionMapper.selectByUserId(userId);
  }
}
