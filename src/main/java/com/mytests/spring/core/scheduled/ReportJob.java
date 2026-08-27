package com.mytests.spring.core.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled smoke test data.
 * <p>
 * The {@code ${report.cron}} placeholder resolves to the {@code report.cron} key
 * in application.properties - Ctrl+Click on it must navigate there.
 * Completion inside an empty {@code cron = ""} must offer the cron macros.
 */
@Component
public class ReportJob {

  @Scheduled(cron = "${report.cron}")
  public void generateNightlyReport() {
    System.out.println("Nightly report generated");
  }

  @Scheduled(fixedRate = 60_000L)
  public void collectMetrics() {
    System.out.println("Metrics collected");
  }
}
