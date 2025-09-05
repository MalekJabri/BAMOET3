package org.acme.wih;

import org.kie.kogito.process.impl.DefaultWorkItemHandlerConfig;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomWorkItemHandlerConfig extends DefaultWorkItemHandlerConfig {

    {
        register("CustomTask", new CustomTaskWorkItemHandler());
    }
}
