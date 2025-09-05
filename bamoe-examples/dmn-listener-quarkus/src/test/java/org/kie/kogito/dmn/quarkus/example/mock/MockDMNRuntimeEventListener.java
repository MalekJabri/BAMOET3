package org.kie.kogito.dmn.quarkus.example.mock;

import java.util.HashMap;
import java.util.Map;

import org.kie.dmn.api.core.event.AfterEvaluateAllEvent;
import org.kie.dmn.api.core.event.BeforeEvaluateAllEvent;
import org.kie.dmn.api.core.event.DMNRuntimeEventListener;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MockDMNRuntimeEventListener implements DMNRuntimeEventListener {

    Map<String, Integer> calls = new HashMap<>();

    public Map<String, Integer> getCalls() {
        return calls;
    }

    public void reset() {
        calls.clear();
    }

    @Override
    public void beforeEvaluateAll(BeforeEvaluateAllEvent event) {
        record("beforeEvaluateAll");
    }

    @Override
    public void afterEvaluateAll(AfterEvaluateAllEvent event) {
        record("afterEvaluateAll");
    }

    private void record(String methodName) {
        if (calls.containsKey(methodName)) {
            calls.put(methodName, calls.get(methodName) + 1);
        } else {
            calls.put(methodName, 1);
        }
    }

}
