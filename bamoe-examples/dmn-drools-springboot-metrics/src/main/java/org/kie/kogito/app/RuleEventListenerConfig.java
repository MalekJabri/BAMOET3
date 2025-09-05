package org.kie.kogito.app;

import org.kie.kogito.drools.core.config.DefaultRuleEventListenerConfig;
import org.kie.kogito.examples.CustomRuleEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import io.micrometer.prometheusmetrics.PrometheusMeterRegistry;

@Configuration
public class RuleEventListenerConfig extends DefaultRuleEventListenerConfig {

    @Autowired
    public RuleEventListenerConfig(PrometheusMeterRegistry prometheusMeterRegistry) {
        super(new CustomRuleEventListener(prometheusMeterRegistry));
    }
}
