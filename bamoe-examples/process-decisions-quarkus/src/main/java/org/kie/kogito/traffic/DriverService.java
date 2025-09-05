package org.kie.kogito.traffic;

import java.time.ZonedDateTime;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DriverService {

    private static Logger LOGGER = LoggerFactory.getLogger(DriverService.class);

    public Driver getDriver(String driverId) {
        LOGGER.info("Get Driver Information for id = {}", driverId);
        //Could call an external service, database, etc.

        //Mocking driver details
        //random expiration based on id, even number will be expired and odd number will be valid
        long days = Long.parseLong(driverId) % 2;
        Date licenseExpiration = new Date(ZonedDateTime.now().plusDays(days).toInstant().toEpochMilli());
        return new Driver(driverId, "Arthur", "SP", "Campinas", 13, 30, licenseExpiration);
    }
}
