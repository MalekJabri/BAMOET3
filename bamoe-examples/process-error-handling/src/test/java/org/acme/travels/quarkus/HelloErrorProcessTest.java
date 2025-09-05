package org.acme.travels.quarkus;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.kie.kogito.Model;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;

import io.quarkus.test.junit.QuarkusTest;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class HelloErrorProcessTest {

    @Named("hello_error")
    @Inject
    Process<? extends Model> helloErrorProcess;

    @Test
    public void testNewTraveller() {

        assertNotNull(helloErrorProcess);

        Model m = helloErrorProcess.createModel();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", "john");
        m.fromMap(parameters);

        ProcessInstance<?> processInstance = helloErrorProcess.createInstance(m);
        processInstance.start();
        assertEquals(org.kie.api.runtime.process.ProcessInstance.STATE_COMPLETED, processInstance.status());
        Model result = (Model) processInstance.variables();
        assertEquals(2, result.toMap().size());
        assertEquals(result.toMap().get("message"), "Hello john");
    }
}
