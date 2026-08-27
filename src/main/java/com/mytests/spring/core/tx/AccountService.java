package com.mytests.spring.core.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Transactions smoke test data (second batch).
 * {@code transactionManager = "txManager"} is a bean-name reference that must
 * resolve to {@link TxConfig#txManager}.
 */
@Service
public class AccountService {

  @Transactional(transactionManager = "txManager")
  public void transfer(String from, String to, long amount) {
    System.out.println("Transferred " + amount + " from " + from + " to " + to);
  }
}
