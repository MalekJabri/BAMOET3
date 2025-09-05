package org.acme.wih;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.kie.api.runtime.process.ProcessWorkItemHandlerException;
import org.kie.kogito.internal.process.workitem.KogitoWorkItem;
import org.kie.kogito.internal.process.workitem.KogitoWorkItemHandler;
import org.kie.kogito.internal.process.workitem.KogitoWorkItemManager;
import org.kie.kogito.internal.process.workitem.WorkItemTransition;
import org.kie.kogito.process.workitems.impl.DefaultKogitoWorkItemHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomTaskWorkItemHandler extends DefaultKogitoWorkItemHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomTaskWorkItemHandler.class);

    @Override
    public Optional<WorkItemTransition> activateWorkItemHandler(KogitoWorkItemManager manager, KogitoWorkItemHandler handler, KogitoWorkItem workItem, WorkItemTransition transition) {
        LOG.debug("start");
        LOG.debug("Passed parameters:");

        // Printing task’s parameters, it will also print
        // our value we pass to the task from the process
        for (String parameter : workItem.getParameters().keySet()) {
            LOG.debug(parameter + " = " + workItem.getParameters().get(parameter));
        }

        String input = (String) workItem.getParameter("Input");

        Map<String, Object> results = new HashMap<String, Object>();
        results.put("Result", "Hello " + input);

        if (input.matches("(RETRY|COMPLETE|RETHROW)")) {
            handleError(input);
        } else if (input.contentEquals("ABORT")) {
            return Optional.of(handler.abortTransition(workItem.getPhaseStatus()));
        } else {
            // Don’t forget to finish the work item otherwise the process
            // will be active infinitely and never will pass the flow
            // to the next node.
            return Optional.of(handler.completeTransition(workItem.getPhaseStatus(), results));
        }

        LOG.debug("end");
        return Optional.empty();
    }

    @Override
    public Optional<WorkItemTransition> abortWorkItemHandler(KogitoWorkItemManager manager, KogitoWorkItemHandler handler, KogitoWorkItem workitem, WorkItemTransition transition) {
        LOG.debug("ABORT!");
        return Optional.empty();
    }

    private void handleError(String strategy) {
        throw new ProcessWorkItemHandlerException("error_handling",
                ProcessWorkItemHandlerException.HandlingStrategy.valueOf(strategy),
                new IllegalStateException(strategy + " strategy test"));
    }

}