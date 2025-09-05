package org.kie.kogito.traffic;

import java.time.ZonedDateTime;
import java.util.Date;

import org.kie.kogito.traffic.licensevalidation.Driver;
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
        String[] parts = driverId.split("-");
        long days = Long.parseLong(parts[0]);
        int points = Integer.parseInt(parts[1]);
        Date licenseExpiration = new Date(ZonedDateTime.now().plusDays(days).toInstant().toEpochMilli());
        return new Driver(driverId, "Arthur", "SP", "Campinas", points, 30, licenseExpiration);
    }
}
