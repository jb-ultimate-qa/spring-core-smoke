package com.mytests.spring.core.events;

/**
 * Plain POJO application event - no ApplicationEvent inheritance, the modern style.
 */
public class OrderCreatedEvent {

  private final String orderId;

  public OrderCreatedEvent(String orderId) {
    this.orderId = orderId;
  }

  public String getOrderId() {
    return orderId;
  }
}
