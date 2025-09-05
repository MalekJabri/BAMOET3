package com.ibm.edu.bamoe.labs.rules.listeners;

import org.kie.kogito.dmn.config.CachedDecisionEventListenerConfig;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@ApplicationScoped
public class DecisionModelEventListenerConfig extends CachedDecisionEventListenerConfig {

    private DecisionModelEventListener listener;

    public DecisionModelEventListenerConfig() {
        super();
    }

    @PostConstruct
    public void setup() {
        
        this.listener = new DecisionModelEventListener();
        register(this.listener);
    }

    @PreDestroy
    public void close() {
        this.listener.cleanup();
    }
}
