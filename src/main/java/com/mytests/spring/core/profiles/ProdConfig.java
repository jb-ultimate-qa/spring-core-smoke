package com.mytests.spring.core.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * The inactive counterpart of {@link DevConfig}: beans defined here must not be
 * part of the running context while "dev" is the active profile.
 */
@Configuration
@Profile("prod")
public class ProdConfig {

  @Bean
  public String prodEndpoint() {
    return "https://prod.example.com";
  }
}
