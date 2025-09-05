package org.kie.kogito.legacy;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieRuntimeBuilder;
import org.kie.api.runtime.KieSession;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/find-approved")
public class FindApprovedLoansEndpoint {

    @Inject
    KieRuntimeBuilder kieRuntimeBuilder;

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<LoanApplication> executeQuery(LoanDto loanDto) {
        KieSession session = kieRuntimeBuilder.newKieSession();

        List<LoanApplication> approvedApplications = new ArrayList<>();
        session.setGlobal("approvedApplications", approvedApplications);
        session.setGlobal("maxAmount", loanDto.getMaxAmount());

        loanDto.getLoanApplications().forEach(session::insert);
        session.fireAllRules();

        return approvedApplications;
    }
}
