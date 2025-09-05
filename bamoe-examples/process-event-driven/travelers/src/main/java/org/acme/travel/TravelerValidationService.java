package org.acme.travel;

import org.drools.ruleunits.api.*;

public class TravelerValidationService implements RuleUnitData {
    private final SingletonStore<Traveler> traveler = DataSource.createSingleton();

    public SingletonStore<Traveler> getTraveler() {
        return traveler;
    }
}
