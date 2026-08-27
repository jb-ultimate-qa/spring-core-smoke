package com.mytests.spring.core.context;

import com.mytests.spring.core.config.GreetingFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Injection site for the Context and Configuration smoke tests.
 * <p>
 * Field injection is used on purpose: it puts exactly one "showAutowiredDependencies"
 * gutter icon on each field line, which keeps the gutter assertions unambiguous.
 * Every field is on its own line so the IDE never merges two Spring gutters into
 * one dropdown icon.
 */
@Component
public class GreetingClient {

  @Autowired
  private GreetingService primaryGreetingService;

  @Autowired
  @Qualifier("frenchGreetingService")
  private GreetingService frenchGreetingService;

  @Autowired
  private GreetingFormatter greetingFormatter;

  public String greetInEnglish(String name) {
    return greetingFormatter.format(primaryGreetingService.greet(name));
  }

  public String greetInFrench(String name) {
    return greetingFormatter.format(frenchGreetingService.greet(name));
  }
}
