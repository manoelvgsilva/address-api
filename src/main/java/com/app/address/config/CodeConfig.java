package com.app.address.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

/**
 * codeconfig.
 */
@Configuration
public class CodeConfig {

  @Value("${api.code.username}")
  private String username;

  @Value("${api.code.password}")
  private String password;

  private BasicAuthenticationInterceptor basicAuthenticationInterceptor;

  /**
   * basicauthenticationinterceptor.
   *
   * @return basicauthenticationinterceptor
   */
  @Bean
  public BasicAuthenticationInterceptor basicAuthenticationInterceptor() {
    return new BasicAuthenticationInterceptor(username, password);
  }
}