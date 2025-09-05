package org.kie.kogito.traffic;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fine {

    @JsonProperty("Amount")
    private Double amount;

    @JsonProperty("Points")
    private Integer points;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
