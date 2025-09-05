package org.kie.kogito.examples;

import org.kie.kogito.testcontainers.quarkus.KafkaQuarkusTestResource;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
@QuarkusTestResource(KafkaQuarkusTestResource.class)
public class NativeDmnEventDrivenIT extends DmnEventDrivenIT {

}
