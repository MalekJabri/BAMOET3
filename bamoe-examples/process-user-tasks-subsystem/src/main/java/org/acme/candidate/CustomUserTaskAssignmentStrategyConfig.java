
package org.acme.candidate;

import java.util.Optional;

import org.kie.kogito.auth.IdentityProvider;
import org.kie.kogito.usertask.UserTaskInstance;
import org.kie.kogito.usertask.impl.BasicUserTaskAssignmentStrategy;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Specializes;

@Specializes
@ApplicationScoped
public class CustomUserTaskAssignmentStrategyConfig extends BasicUserTaskAssignmentStrategy {

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Optional<String> computeAssignment(UserTaskInstance userTaskInstance, IdentityProvider identityProvider) {
        System.out.println("Computing assignment using custom User Task assignment strategy.");
        // Your custom logic goes here. For example:
        if ("hr_interview".equals(userTaskInstance.getTaskName())) {
            return Optional.of("recruiter");
        } else if ("it_interview".equals(userTaskInstance.getTaskName())) {
            return Optional.of("developer");
        } else {
            return Optional.empty();
        }
    }
}
