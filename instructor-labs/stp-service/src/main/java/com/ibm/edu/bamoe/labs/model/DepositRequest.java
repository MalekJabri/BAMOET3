package com.ibm.edu.bamoe.labs.model;

import java.util.List;

public class DepositRequest {

    private Integer maxAmount;
    private List<Deposit> deposits;
    private List<AllAmounts> allAmounts;

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    public List<AllAmounts> getAllAmounts() {
        return this.allAmounts;
    }

    public void setAllAmounts(List<AllAmounts> allAmounts) {
        this.allAmounts = allAmounts;
    }

    @Override
    public String toString() {
        return "deposit request [maxAmount=" + getMaxAmount() + ", deposits=" + getDeposits() + "]";
    }
}
