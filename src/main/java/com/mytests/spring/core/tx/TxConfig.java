package com.mytests.spring.core.tx;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Declares the {@code txManager} bean referenced by
 * {@link AccountService#transfer} - the resolution target for the Transactions
 * test in the second batch. Declared explicitly rather than relying on Boot's
 * auto-configured manager, so the bean-name reference always resolves.
 */
@Configuration
public class TxConfig {

  @Bean("txManager")
  public PlatformTransactionManager txManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
}
