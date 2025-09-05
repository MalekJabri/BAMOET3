package com.ibm.edu.bamoe.labs.service;

import java.util.List;
import java.util.Iterator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import jakarta.enterprise.context.ApplicationScoped;

import com.ibm.edu.bamoe.labs.model.Customer;
import com.ibm.edu.bamoe.labs.model.rules.ExecutionDuration;
import com.ibm.edu.bamoe.labs.model.rules.RuleResults;
import com.ibm.edu.bamoe.labs.rules.listeners.RuleEventListener;

@ApplicationScoped
public class ClassicRuleService {

    private static final Logger logger = LoggerFactory.getLogger(ClassicRuleService.class);
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public RuleResults processCustomers(List<Customer> customers) {

        // Mark the start time
        LocalDateTime startedOn = LocalDateTime.now();

        // Create the KIE session and classpath container
        logger.debug("\r\nCreating kie session and classpath container...");
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();        
        KieSession kieSession = kieContainer.newKieSession();
        KieBase kieBase = kieSession.getKieBase();

        // Add an event listener
        logger.debug("--> Attaching event listener...");
        kieSession.addEventListener(new RuleEventListener());

        // Prepare the facts and execute the ruleset
        logger.debug("--> Inserting facts into rule engine instance...");

        Iterator<Customer> iCustomers = customers.iterator();
        while (iCustomers.hasNext()) {

            Customer customer = (Customer) iCustomers.next();
            kieSession.insert(customer);
        }

        // Execute the rules
        logger.debug("--> Executing ruleset...");
        int rulesFired = kieSession.fireAllRules();

        // Be sure to dispose of the session
        kieSession.dispose();

        // Mark completion time        
        LocalDateTime completedOn = LocalDateTime.now();

        // Report
        ExecutionDuration duration = calculateExecutionDuration(startedOn, completedOn);
        logger.debug("Rule Execution started: " + startedOn + ", ended: " + completedOn + ", rules fired: " + rulesFired + ", duration: " + duration + "...");

        // Prepare the execution results
        RuleResults results = new RuleResults();
        results.setStartedOn(formatLocalDateTime(startedOn));
        results.setCompletedOn(formatLocalDateTime(completedOn));
        results.setExecutionDuration(duration);
        results.setFiredRuleCount(rulesFired);

        // Add the updated facts
        results.getFacts().add(customers);
        logger.info("Rule Execution Results: " + results);

        // Return the results
        return results;
    }


    protected ExecutionDuration calculateExecutionDuration(LocalDateTime begin, LocalDateTime end) {

        ExecutionDuration ed = new ExecutionDuration();
        ed.setDays(ChronoUnit.DAYS.between(begin, end));
        ed.setHours(ChronoUnit.HOURS.between(begin, end));
        ed.setMinutes(ChronoUnit.MINUTES.between(begin, end));
        ed.setSeconds(ChronoUnit.SECONDS.between(begin, end));
        ed.setMilliseconds(ChronoUnit.MILLIS.between(begin, end));
        return ed;
   }

   protected String formatLocalDateTime(LocalDateTime ldt) {

       DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
       return ldt.format(formatter);
   }
}
