package com.mytests.spring.core.caching;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Caching smoke test data. All three methods share the {@code books} cache,
 * so the "showCacheable" gutter icon on {@link #findBook} navigates to the
 * other two.
 * <p>
 * Keep every cache annotation on its own line: two Spring gutters on one line
 * are merged by the IDE into a single dropdown icon.
 */
@Service
public class BookService {

  @Cacheable("books")
  public String findBook(String isbn) {
    return "Book " + isbn;
  }

  @CachePut("books")
  public String updateBook(String isbn) {
    return "Updated book " + isbn;
  }

  @CacheEvict("books")
  public void deleteBook(String isbn) {
    System.out.println("Deleted book " + isbn);
  }
}
