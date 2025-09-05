package org.kie.kogito.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class StockService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockService.class);

    @Inject
    MockService mockService;

    public Response reserveStock(String orderId, String failService) {
        LOGGER.info("Reserve Stock for order {}", orderId);
        return mockService.execute(failService, StockService.class, false);
    }

    public Response reserveStock(String orderId, String failService, String throwException) {
        LOGGER.info("Reserve Stock for order {}", orderId);
        return mockService.execute(failService, StockService.class, Boolean.parseBoolean(throwException));
    }

    public Response cancelStock(String id) {
        LOGGER.info("Cancel Stock for  order {}", id);
        return new Response(Response.Type.SUCCESS, id);
    }
}
