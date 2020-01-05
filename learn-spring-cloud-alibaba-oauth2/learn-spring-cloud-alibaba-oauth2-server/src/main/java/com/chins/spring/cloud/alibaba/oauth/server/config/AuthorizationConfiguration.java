package com.chins.spring.cloud.alibaba.oauth.server.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfiguration extends AuthorizationServerConfigurerAdapter {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public TokenStore tokenStore() {
    return new JdbcTokenStore(dataSource());
  }

  @Bean
  public ClientDetailsService jdbcClientDetailsService() {
    return new JdbcClientDetailsService(dataSource());
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

    clients.withClientDetails(jdbcClientDetailsService());
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    endpoints.tokenStore(tokenStore());
  }

//  @Override
//  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//
//    clients.inMemory().withClient("client").secret(passwordEncoder.encode("secret"))
//        .authorizedGrantTypes("authorization_code").scopes("app")
//        .redirectUris("https://www.baidu.com");
//  }


}
