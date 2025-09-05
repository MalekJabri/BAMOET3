package org.acme.travels.services;

import org.acme.travels.quarkus.Traveller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TravellerAuditService {

    private static final Logger logger = LoggerFactory.getLogger(TravellerAuditService.class);

    public Traveller auditTraveller(Traveller traveller) {

        logger.info("Traveller {} is being processed", traveller.toString());

        return traveller;
    }
}
