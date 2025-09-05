package org.kie.kogito.examples.quarkus;

import java.util.Random;

import org.kie.kogito.examples.quarkus.demo.Order;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculationService {

    private Random random = new Random();

    public Order calculateTotal(Order order) {
        order.setTotal(random.nextDouble());

        return order;
    }
}
