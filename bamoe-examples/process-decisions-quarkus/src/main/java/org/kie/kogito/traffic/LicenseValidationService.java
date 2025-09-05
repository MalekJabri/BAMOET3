package org.kie.kogito.traffic;

import java.util.Date;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.RuleUnitData;
import org.drools.ruleunits.api.SingletonStore;

public class LicenseValidationService implements RuleUnitData {
    private SingletonStore<Driver> driver;

    public LicenseValidationService() {
        this(DataSource.createSingleton());
    }

    public LicenseValidationService(SingletonStore<Driver> driver) {
        this.driver = driver;
    }

    public void setDriver(SingletonStore<Driver> driver) {
        this.driver = driver;
    }

    public SingletonStore<Driver> getDriver() {
        return driver;
    }

    public Date getCurrentTime() {
        return new Date();
    }
}
