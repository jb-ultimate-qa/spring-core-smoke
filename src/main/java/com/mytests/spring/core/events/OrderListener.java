package com.mytests.spring.core.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Listener side of the Events smoke test.
 * The {@code @EventListener} method below carries the "listener" gutter icon,
 * which navigates back to {@link OrderPublisher#createOrder}.
 */
@Component
public class OrderListener {

  @EventListener
  public void onOrderCreated(OrderCreatedEvent event) {
    System.out.println("Order created: " + event.getOrderId());
  }
}
