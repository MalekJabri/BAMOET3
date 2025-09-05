package com.ibm.edu.bamoe.labs.model.rules;

import java.util.ArrayList;
import java.util.List;

public class RuleResults {

    private String startedOn;
    private String completedOn;
    private int firedRuleCount;
    private ExecutionDuration executionDuration;
    private List<Object> facts = new ArrayList<Object>();

    public String getStartedOn() {
        return this.startedOn;
    }

    public void setStartedOn(String startedOn) {
        this.startedOn = startedOn;
    }

    public String getCompletedOn() {
        return this.completedOn;
    }

    public void setCompletedOn(String completedOn) {
        this.completedOn = completedOn;
    }

    public int getFiredRuleCount() {
        return this.firedRuleCount;
    }

    public void setFiredRuleCount(int firedRuleCount) {
        this.firedRuleCount = firedRuleCount;
    }

    public ExecutionDuration getExecutionDuration() {
        return this.executionDuration;
    }

    public void setExecutionDuration(ExecutionDuration executionDuration) {
        this.executionDuration = executionDuration;
    }

    public List<Object> getFacts() {
        return this.facts;
    }

    public void setFacts(List<Object> facts) {
        this.facts = facts;
    }

    @Override
    public String toString() {
        return "startedOn=" + startedOn + ", completedOn=" + completedOn + ", firedRuleCount=" + firedRuleCount + ", executionDuration=" + executionDuration + ", updatedFacts=" + getFacts();
    }
}