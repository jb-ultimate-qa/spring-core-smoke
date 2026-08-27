package com.mytests.spring.core.async;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Declares the {@code mailExecutor} bean referenced by
 * {@link MailService#sendConfirmation} - the resolution target for the
 * Async test in the second batch.
 */
@Configuration
@EnableAsync
public class AsyncConfig {

  @Bean("mailExecutor")
  public Executor mailExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setThreadNamePrefix("mail-");
    executor.initialize();
    return executor;
  }
}
