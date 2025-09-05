package org.kie.kogito.examples;

import java.util.concurrent.atomic.AtomicInteger;

import org.drools.core.event.DefaultAgendaEventListener;
import org.jboss.logging.Logger;
import org.kie.api.event.rule.AfterMatchFiredEvent;

import jakarta.inject.Singleton;

@Singleton
public class MyAgendaEventListener extends DefaultAgendaEventListener {
    private static final Logger LOG = Logger.getLogger(MyAgendaEventListener.class);

    AtomicInteger counter = new AtomicInteger();

    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        int count = counter.incrementAndGet();
        LOG.infof("Event fired %d time(s).", count);
    }
}
