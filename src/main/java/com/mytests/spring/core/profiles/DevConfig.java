package com.mytests.spring.core.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Profiles smoke test data. The "dev" profile is the one activated by
 * {@code spring.profiles.active} in application.properties, so completion
 * inside {@code @Profile("")} must offer both "dev" and "prod".
 */
@Configuration
@Profile("dev")
public class DevConfig {

  @Bean
  public String devEndpoint() {
    return "http://localhost:8080";
  }
}
