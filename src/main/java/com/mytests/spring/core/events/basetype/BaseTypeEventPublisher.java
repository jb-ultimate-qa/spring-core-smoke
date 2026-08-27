package com.mytests.spring.core.events.basetype;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Single publish site for the base-type navigation scenario.
 * Its "publisher" gutter icon must offer all three project listeners:
 * {@link TypedApplicationListener}, {@link CatchAllApplicationListener} and
 * {@link BaseTypeAnnotatedListener}.
 */
@Service
public class BaseTypeEventPublisher {

  private final ApplicationEventPublisher eventPublisher;

  public BaseTypeEventPublisher(ApplicationEventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  public void publishMyEvent(String payload) {
    eventPublisher.publishEvent(new MyApplicationEvent(this, payload));
  }
}
