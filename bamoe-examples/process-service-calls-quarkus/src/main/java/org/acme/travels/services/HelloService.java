package org.acme.travels.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {

    private static final Logger logger = LoggerFactory.getLogger(GreetingTravellerService.class);

    public Object hello(String name, Integer age) {
        logger.info("Saying hello to {} with age {}", name, age);

        return "";
    }
}
