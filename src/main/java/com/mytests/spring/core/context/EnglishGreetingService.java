package com.mytests.spring.core.context;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * The @Primary candidate. Carries the "showAutowiredCandidates" gutter icon,
 * which navigates to the places this bean is injected into
 * ({@link GreetingClient#primaryGreetingService}).
 */
@Service
@Primary
public class EnglishGreetingService implements GreetingService {

  @Override
  public String greet(String name) {
    return "Hello, " + name;
  }
}
