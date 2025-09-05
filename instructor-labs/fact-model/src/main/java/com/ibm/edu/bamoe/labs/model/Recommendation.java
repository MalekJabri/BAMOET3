package com.ibm.edu.bamoe.labs.model;

public class Recommendation {

    private String actionTaken;
    private String message;

    public String getActionTaken() {
        return this.actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[recommendation actionTaken=" + getActionTaken() + ", message=" + getMessage() + "]";
    }
}
