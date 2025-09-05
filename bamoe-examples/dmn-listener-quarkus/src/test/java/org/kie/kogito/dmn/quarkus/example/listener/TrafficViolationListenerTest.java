package org.kie.kogito.dmn.quarkus.example.listener;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.kie.dmn.api.core.event.DMNRuntimeEventListener;
import org.kie.kogito.decision.DecisionConfig;
import org.kie.kogito.decision.DecisionEventListenerConfig;
import org.kie.kogito.dmn.quarkus.example.mock.MockDMNRuntimeEventListener;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import jakarta.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.kie.kogito.dmn.quarkus.example.listener.TrafficViolationTest.TRAFFIC_VIOLATION_TEST_BODY;

@QuarkusTest
public class TrafficViolationListenerTest {

    @Inject
    DecisionConfig decisionConfig;

    @Test
    public void testEvaluateTrafficViolation() {
        List<DMNRuntimeEventListener> injectedListeners = Optional.ofNullable(decisionConfig)
                .map(DecisionConfig::decisionEventListeners)
                .map(DecisionEventListenerConfig::listeners)
                .orElseThrow(() -> new IllegalStateException("Can't find injected listeners"));

        assertEquals(4, injectedListeners.size());

        MockDMNRuntimeEventListener testListener = injectedListeners.stream()
                .filter(MockDMNRuntimeEventListener.class::isInstance)
                .findFirst()
                .map(MockDMNRuntimeEventListener.class::cast)
                .orElseThrow(() -> new IllegalStateException("Can't find injected MockDMNRuntimeEventListener"));

        testListener.reset();

        given().body(TRAFFIC_VIOLATION_TEST_BODY).contentType(ContentType.JSON).post("/Traffic Violation");

        Map<String, Integer> testListenerCalls = testListener.getCalls();
        assertTrue(testListenerCalls.containsKey("beforeEvaluateAll"));
        assertEquals(1, testListenerCalls.get("beforeEvaluateAll"));
        assertTrue(testListenerCalls.containsKey("afterEvaluateAll"));
        assertEquals(1, testListenerCalls.get("afterEvaluateAll"));
    }

}
