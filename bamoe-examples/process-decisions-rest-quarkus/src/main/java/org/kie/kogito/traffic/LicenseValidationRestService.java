package org.kie.kogito.traffic;

import java.util.Collections;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LicenseValidationRestService {

    @Inject
    @RestClient
    LicenseValidationRestClient client;

    public Driver evaluate(Driver driver) {
        return client.post(Collections.singletonMap("driver", driver));
    }
}
