package com.mytests.spring.core.events.basetype;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Listener typed to the concrete event class - the narrowest of the three.
 */
@Component
public class TypedApplicationListener implements ApplicationListener<MyApplicationEvent> {

  @Override
  public void onApplicationEvent(MyApplicationEvent event) {
    System.out.println("Typed listener received: " + event.getPayload());
  }
}
