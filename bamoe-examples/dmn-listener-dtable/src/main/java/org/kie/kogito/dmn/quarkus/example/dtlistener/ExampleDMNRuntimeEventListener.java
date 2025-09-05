package org.kie.kogito.dmn.quarkus.example.dtlistener;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.kie.dmn.api.core.event.AfterEvaluateDecisionTableEvent;
import org.kie.dmn.core.api.event.DefaultDMNRuntimeEventListener;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * This class demonstrates one possible use of the `AfterEvaluateDecisionTableEvent` asynchronously to the listener.
 */
@ApplicationScoped
public class ExampleDMNRuntimeEventListener extends DefaultDMNRuntimeEventListener {
    // using a ConcurrentLinkedQueue to avoid ConcurrentModificationException
    private Queue<AfterEvaluateDecisionTableEvent> events = new ConcurrentLinkedQueue<>();

    @Override
    public void afterEvaluateDecisionTable(AfterEvaluateDecisionTableEvent event) {
        // Maintaining listener callback code as small as possible.
        events.add(event);
    }

    public Queue<AfterEvaluateDecisionTableEvent> getEvents() {
        return events;
    }
}
