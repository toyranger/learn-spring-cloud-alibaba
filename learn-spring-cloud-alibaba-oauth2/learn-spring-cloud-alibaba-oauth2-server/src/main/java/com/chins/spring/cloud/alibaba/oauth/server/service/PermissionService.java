package com.chins.spring.cloud.alibaba.oauth.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chins.spring.cloud.alibaba.oauth.server.domain.Permission;
import java.util.List;

public interface PermissionService extends IService<Permission> {

  List<Permission> selectByUserId(Long userId);
}
