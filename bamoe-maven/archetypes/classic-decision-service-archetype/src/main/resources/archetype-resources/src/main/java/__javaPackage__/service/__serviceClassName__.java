package ${package}.service;

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

import ${package}.model.rules.RuleResults;
import ${package}.model.rules.ExecutionDuration;

@ApplicationScoped
public class ${serviceClassName} {

    private static final Logger logger = LoggerFactory.getLogger(${serviceClassName}.class);
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /*
     * 
     * This method accepts the incoming data objects for this service, sets up the embedded DLR engine API, executes
     * the rules, and processes the results.  
     * 
     * You should replace this method's parameters with something specific to your use case, either coming in from a REST
     * API call or to be called by other Java code.  Here we are specifying a list of objects, but clearly you want to 
     * replace this with your own set of data objects for your rule services.
     * 
     */
    public RuleResults execute(List<Object> facts) {

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
        kieSession.addEventListener(new DebugRuleRuntimeEventListener());

        // Prepare the facts and execute the ruleset
        logger.debug("--> Inserting facts into rule engine instance...");

        /*
         * Here we are iterating over the collection of "fact" classes and inserting into working memory.  You should 
         * replace this with the actual input parameter and be sure to cast properly
         */
        Iterator<Object> iFacts = facts.iterator();
        while (iFacts.hasNext()) {

            Object fact = (Object) iFacts.next();
            kieSession.insert(fact);
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
        results.getFacts().add(facts);
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
