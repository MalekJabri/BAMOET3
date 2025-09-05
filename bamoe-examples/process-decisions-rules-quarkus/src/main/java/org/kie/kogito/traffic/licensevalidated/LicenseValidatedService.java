package org.kie.kogito.traffic.licensevalidated;

import java.util.Date;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.RuleUnitData;
import org.drools.ruleunits.api.SingletonStore;

public class LicenseValidatedService implements RuleUnitData {
    private SingletonStore<Validated> validated;

    public LicenseValidatedService() {
        this(DataSource.createSingleton());
    }

    public LicenseValidatedService(SingletonStore<Validated> validated) {
        this.validated = validated;
    }

    public void setValidated(SingletonStore<Validated> validated) {
        this.validated = validated;
    }

    public SingletonStore<Validated> getValidated() {
        return validated;
    }

    public Date getCurrentTime() {
        return new Date();
    }
}
