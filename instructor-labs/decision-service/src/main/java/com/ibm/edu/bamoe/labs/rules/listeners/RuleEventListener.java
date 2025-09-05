package com.ibm.edu.bamoe.labs.rules.listeners;

import org.drools.core.event.DefaultAgendaEventListener;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuleEventListener extends DefaultAgendaEventListener {

    private static final Logger logger = LoggerFactory.getLogger(RuleEventListener.class);

    @Override
    public void beforeMatchFired(BeforeMatchFiredEvent event) {
        logger.info("beforeMatchFired: {}" + event);
    }

    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        logger.info("afterMatchFired: {}" + event);
    }
}



