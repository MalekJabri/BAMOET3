package com.ibm.edu.bamoe.labs.rules.listeners;

import org.kie.kogito.drools.core.config.DefaultRuleEventListenerConfig;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RuleEventListenerConfig extends DefaultRuleEventListenerConfig {

    @Inject
    public RuleEventListenerConfig() {
        super(new RuleEventListener());
    }
}
