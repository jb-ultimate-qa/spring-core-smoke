package com.mytests.spring.core.events.basetype;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Annotation-driven listener declared against the {@code ApplicationEvent} base
 * type - the third target the publisher gutter must offer.
 * <p>
 * Counts instead of printing, for the same reason as
 * {@link CatchAllApplicationListener}.
 */
@Component
public class BaseTypeAnnotatedListener {

  private final AtomicLong receivedCount = new AtomicLong();

  @EventListener
  public void onAnyApplicationEvent(ApplicationEvent event) {
    receivedCount.incrementAndGet();
  }

  public long getReceivedCount() {
    return receivedCount.get();
  }
}
