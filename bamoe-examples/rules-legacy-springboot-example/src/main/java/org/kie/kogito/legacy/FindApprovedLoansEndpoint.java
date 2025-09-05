package org.kie.kogito.legacy;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieRuntimeBuilder;
import org.kie.api.runtime.KieSession;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find-approved")
public class FindApprovedLoansEndpoint {

    private final KieRuntimeBuilder kieRuntimeBuilder;

    public FindApprovedLoansEndpoint(KieRuntimeBuilder kieRuntimeBuilder) {
        this.kieRuntimeBuilder = kieRuntimeBuilder;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<LoanApplication> executeQuery(@RequestBody(required = true) LoanDto loanDto) {
        KieSession session = kieRuntimeBuilder.newKieSession();

        List<LoanApplication> approvedApplications = new ArrayList<>();
        session.setGlobal("approvedApplications", approvedApplications);
        session.setGlobal("maxAmount", loanDto.getMaxAmount());

        loanDto.getLoanApplications().forEach(session::insert);
        session.fireAllRules();

        return approvedApplications;
    }
}
