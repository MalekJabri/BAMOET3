package org.kie.kogito.traffic.licensevalidated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Validated {

    @JsonProperty("Suspended")
    private String suspended;

    @JsonProperty("ValidLicense")
    private Boolean validLicense = Boolean.FALSE;

    public Validated() {
    }

    public Validated(String suspended) {
        this.suspended = suspended;
    }

    public String getSuspended() {
        return suspended;
    }

    public Boolean isValidLicense() {
        return validLicense;
    }

    public Boolean getValidLicense() {
        return validLicense;
    }

    public void setValidLicense(Boolean validLicense) {
        this.validLicense = validLicense;
    }
}
