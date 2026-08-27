package com.mytests.spring.core.events;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Publisher side of the Events smoke test.
 * <p>
 * All three publish sites below carry the "publisher" gutter icon, which
 * navigates to {@link OrderListener#onOrderCreated}. They are deliberately
 * kept as three separate methods, one publish call per line, so each gutter
 * icon can be asserted on its own line.
 */
@Service
public class OrderPublisher {

  private final ApplicationEventPublisher eventPublisher;

  public OrderPublisher(ApplicationEventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  public void createOrder(String orderId) {
    eventPublisher.publishEvent(new OrderCreatedEvent(orderId));
  }

  public void publishAllWithLambda(List<OrderCreatedEvent> events) {
    //noinspection Convert2MethodRef - the lambda form is the thing under test here
    events.forEach(event -> eventPublisher.publishEvent(event));
  }

  public void publishAllWithMethodReference(List<OrderCreatedEvent> events) {
    events.forEach(eventPublisher::publishEvent);
  }
}
