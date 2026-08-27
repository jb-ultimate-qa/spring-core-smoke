package com.mytests.spring.core.config;

/**
 * Plain class, deliberately not annotated: it becomes a bean only through the
 * {@code @Bean} factory method in {@link AppConfig}.
 */
public class GreetingFormatter {

  private final String pattern;

  public GreetingFormatter(String pattern) {
    this.pattern = pattern;
  }

  public String format(String message) {
    return String.format(pattern, message);
  }
}
