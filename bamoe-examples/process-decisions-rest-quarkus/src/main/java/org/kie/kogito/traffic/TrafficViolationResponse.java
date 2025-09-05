package org.kie.kogito.traffic;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrafficViolationResponse {

    @JsonProperty("Fine")
    private Fine fine;

    @JsonProperty("Suspended")
    private String suspended;

    public Fine getFine() {
        return fine;
    }

    public void setFine(Fine fine) {
        this.fine = fine;
    }

    public String getSuspended() {
        return suspended;
    }

    public Boolean isSuspended() {
        return "Yes".equals(suspended);
    }

    public void setSuspended(String suspended) {
        this.suspended = suspended;
    }
}
