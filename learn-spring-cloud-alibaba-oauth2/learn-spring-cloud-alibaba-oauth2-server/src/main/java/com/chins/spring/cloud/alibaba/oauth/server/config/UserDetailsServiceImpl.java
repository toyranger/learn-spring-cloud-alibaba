package com.chins.spring.cloud.alibaba.oauth.server.config;

import com.chins.spring.cloud.alibaba.oauth.server.domain.Permission;
import com.chins.spring.cloud.alibaba.oauth.server.domain.User;
import com.chins.spring.cloud.alibaba.oauth.server.service.PermissionService;
import com.chins.spring.cloud.alibaba.oauth.server.service.UserService;
import java.util.List;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Autowired
  private PermissionService permissionService;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

    User userByUsername = userService.getUserByUsername(s);

    List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();

    if (null != userByUsername) {
      List<Permission> permissions = permissionService.selectByUserId(userByUsername.getId());
      permissions.forEach(permission -> {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnname());
        grantedAuthorities.add(grantedAuthority);
      });
      return new org.springframework.security.core.userdetails.User(userByUsername.getUsername(),
          userByUsername.getPassword(), grantedAuthorities);
    }

    return null;
  }
}
