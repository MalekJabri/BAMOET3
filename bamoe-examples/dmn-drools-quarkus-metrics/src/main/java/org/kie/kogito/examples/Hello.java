package org.kie.kogito.examples;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class Hello implements RuleUnitData {

    DataStore<String> strings = DataSource.createStore();

    public DataStore<String> getStrings() {
        return strings;
    }
}
