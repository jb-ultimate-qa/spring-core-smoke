package com.mytests.spring.core.events.basetype;

import org.springframework.context.ApplicationEvent;

/**
 * Event for the base-type navigation scenario. Unlike
 * {@code events.OrderCreatedEvent} this one extends {@link ApplicationEvent},
 * so it is matched both by listeners typed to this exact class and by listeners
 * typed to the {@code ApplicationEvent} base type.
 */
public class MyApplicationEvent extends ApplicationEvent {

  private final String payload;

  public MyApplicationEvent(Object source, String payload) {
    super(source);
    this.payload = payload;
  }

  public String getPayload() {
    return payload;
  }
}
