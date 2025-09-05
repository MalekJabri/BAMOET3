package com.ibm.edu.bamoe.labs.rules;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

import com.ibm.edu.bamoe.labs.model.Deposit;
import com.ibm.edu.bamoe.labs.model.AllAmounts;

public class DepositUnit implements RuleUnitData {

    private int maxAmount;
    private DataStore<Deposit> deposits;
    private DataStore<AllAmounts> allAmounts;

    public DepositUnit() {
        this(DataSource.createStore(), DataSource.createStore());
    }

    public DepositUnit(DataStore<Deposit> deposits, DataStore<AllAmounts> allAmounts) {

        this.deposits = deposits;
        this.allAmounts = allAmounts;
    }

    public DataStore<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(DataStore<Deposit> deposits) {
        this.deposits = deposits;
    }

    public DataStore<AllAmounts> getAllAmounts() {
        return allAmounts;
    }

    public void setAllAmounts(DataStore<AllAmounts> allAmounts) {
        this.allAmounts = allAmounts;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }
}
