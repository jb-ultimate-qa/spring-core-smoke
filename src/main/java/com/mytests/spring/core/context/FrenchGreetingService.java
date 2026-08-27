package com.mytests.spring.core.context;

import org.springframework.stereotype.Service;

/**
 * The non-primary candidate, reached only through an explicit @Qualifier.
 */
@Service
public class FrenchGreetingService implements GreetingService {

  @Override
  public String greet(String name) {
    return "Bonjour, " + name;
  }
}
