package com.mytests.spring.core.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Async smoke test data (second batch).
 * {@code @Async("mailExecutor")} is a bean-name reference that must resolve to
 * {@link AsyncConfig#mailExecutor}.
 */
@Service
public class MailService {

  @Async("mailExecutor")
  public void sendConfirmation(String address) {
    System.out.println("Confirmation sent to " + address);
  }
}
