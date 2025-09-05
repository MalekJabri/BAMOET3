package org.kie.kogito.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ShippingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShippingService.class);

    @Inject
    MockService mockService;

    public Response scheduleShipping(String orderId, String failService) {
        LOGGER.info("Schedule Shipping for order {}", orderId);
        return mockService.execute(failService, ShippingService.class, false);
    }

    public Response scheduleShipping(String orderId, String failService, String throwException) {
        LOGGER.info("Schedule Shipping for order {}", orderId);
        return mockService.execute(failService, ShippingService.class, Boolean.parseBoolean(throwException));
    }

    public Response cancelShipping(String id) {
        LOGGER.info("Cancel Shipping for  order {}", id);
        return new Response(Response.Type.SUCCESS, id);
    }
}
