package com.mytests.spring.core.ideux;

import org.springframework.stereotype.Repository;

/**
 * The project's only @Repository bean. It exists so the "Show Repositories"
 * filter in the Autowire Bean popup has something to show, and so the
 * repository-specific checks in IJQA-351 have a target.
 * <p>
 * Deliberately a plain @Repository class rather than a Spring Data interface:
 * the stereotype lives in spring-context, so this adds no new dependency and no
 * import cost to the other cases.
 */
@Repository
public class BookRepository {

  public String findTitle(String isbn) {
    return "Title for " + isbn;
  }
}
