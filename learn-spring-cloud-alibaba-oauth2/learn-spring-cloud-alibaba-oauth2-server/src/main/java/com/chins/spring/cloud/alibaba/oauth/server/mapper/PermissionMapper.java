package com.chins.spring.cloud.alibaba.oauth.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chins.spring.cloud.alibaba.oauth.server.domain.Permission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper extends BaseMapper<Permission> {

  List<Permission> selectByUserId(@Param("userId") Long userId);
}
