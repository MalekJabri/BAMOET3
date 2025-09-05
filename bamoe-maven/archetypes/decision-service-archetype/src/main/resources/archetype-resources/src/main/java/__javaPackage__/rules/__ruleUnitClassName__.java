package ${package}.rules;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class ${ruleUnitClassName} implements RuleUnitData {

    /*
     * Add rule unit storage classes, which essentially provide the public API for the rule service.  The following is an example of how you would
     * create a RuleUnit that takes a collection of Deposit objects and returns a collection of AllAmounts....
     * 
     * These unit classes would be replaced with the actual fact-model classes your decision service is based on...
     */

    // private DataStore<Deposit> deposits;
    // private DataStore<AllAmounts> allAmounts;

    /*
     * Example of default construtor.  Be sure to call the .create method for each type of unit variable
     */
    public ${ruleUnitClassName}() {
        // this(DataSource.createStore(), DataSource.createStore());
    }

    /*
     * Example of construtor that takes into account the rule unit data
     *
    public ${ruleUnitClassName}(DataStore<Deposit> deposits, DataStore<AllAmounts> allAmounts) {

        // this.deposits = deposits;
        // this.allAmounts = allAmounts;
    }
    */

    /*
     * Various getters/setters for rule unit data
     * 
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
    */
}
