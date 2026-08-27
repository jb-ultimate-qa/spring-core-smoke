package com.mytests.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration smoke test data.
 * <p>
 * {@code @ComponentScan} carries the "springScan" gutter icon, and the
 * {@code @Bean} factory method carries the "springBeanMethod" gutter icon,
 * which navigates to {@code GreetingClient#greetingFormatter}.
 */
@Configuration
@ComponentScan(basePackages = "com.mytests.spring.core")
public class AppConfig {

  @Bean
  public GreetingFormatter greetingFormatter() {
    return new GreetingFormatter("<< %s >>");
  }
}
