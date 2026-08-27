package com.mytests.spring.core.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Profile expression: an array of profile names. Active when either "dev" or
 * "test" is active, so it is active under the default
 * {@code spring.profiles.active=dev}.
 * <p>
 * This is the only declaration of the "test" profile in the project, so it is
 * what puts "test" into the profile-name completion index. Removing it drops the
 * completion baseline back to "dev" and "prod".
 */
@Configuration
@Profile({"dev", "test"})
public class MultiProfileConfig {

  @Bean
  public String sharedEndpoint() {
    return "http://shared.local";
  }
}
