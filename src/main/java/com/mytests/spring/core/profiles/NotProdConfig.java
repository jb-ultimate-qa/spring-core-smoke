package com.mytests.spring.core.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Profile expression: negation. Active whenever "prod" is NOT active, so under
 * the default {@code spring.profiles.active=dev} this configuration is ACTIVE -
 * the exact opposite of {@link ProdConfig}, which is inactive there.
 * <p>
 * That contrast is the point: it is what makes the inactive/active rendering
 * check meaningful rather than trivially true.
 */
@Configuration
@Profile("!prod")
public class NotProdConfig {

  @Bean
  public String nonProdEndpoint() {
    return "http://non-prod.local";
  }
}
