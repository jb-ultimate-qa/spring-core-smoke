package com.mytests.spring.core.events.basetype;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Listener typed to the {@code ApplicationEvent} base type, so it matches every
 * event in the context - including the plain-POJO events from the
 * {@code events} package, which Spring wraps in a PayloadApplicationEvent.
 * <p>
 * Counts instead of printing: this fires for every framework event too, and a
 * println here would flood the console whenever the application is run.
 */
@Component
public class CatchAllApplicationListener implements ApplicationListener<ApplicationEvent> {

  private final AtomicLong receivedCount = new AtomicLong();

  @Override
  public void onApplicationEvent(ApplicationEvent event) {
    receivedCount.incrementAndGet();
  }

  public long getReceivedCount() {
    return receivedCount.get();
  }
}
