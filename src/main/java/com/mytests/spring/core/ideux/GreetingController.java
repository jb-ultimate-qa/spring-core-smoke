package com.mytests.spring.core.ideux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the "Request Mapping in controller" generate case (IJQA-351).
 * <p>
 * Deliberately injects nothing. A generated {@code @SpringBootApplication} placed in
 * this package scans only this package, so any dependency on a bean from another
 * package - for example {@code context.GreetingService} - would make the generated
 * application fail to start. Keep this class self-contained.
 * <p>
 * Requires spring-boot-starter-web; if that dependency is ever dropped from the pom,
 * this class and its case go with it.
 */
@RestController
public class GreetingController {


  @GetMapping("/greet")
  public String greet(String name) {
    return "Hello, " + name;
  }
}
