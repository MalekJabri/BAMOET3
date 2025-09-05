package org.kie.kogito.legacy;

import org.kie.api.runtime.KieRuntimeBuilder;
import org.kie.api.runtime.KieSession;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find-approved")
public class HelloEndpoint {

    private final KieRuntimeBuilder kieRuntimeBuilder;

    public HelloEndpoint(KieRuntimeBuilder kieRuntimeBuilder) {
        this.kieRuntimeBuilder = kieRuntimeBuilder;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Hello executeQuery(@RequestBody(required = true) Hello hello) {
        KieSession session = kieRuntimeBuilder.newKieSession();

        session.insert(hello);
        session.fireAllRules();

        return hello;
    }
}
