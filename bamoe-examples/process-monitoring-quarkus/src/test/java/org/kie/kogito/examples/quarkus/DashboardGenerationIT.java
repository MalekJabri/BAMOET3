package org.kie.kogito.examples.quarkus;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@QuarkusIntegrationTest
public class DashboardGenerationIT {

    @Test
    @SuppressWarnings("unchecked")
    public void testDashboardsListIsAvailable() {
        List<String> dashboards = given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().get("/monitoring/dashboards/list.json").as(List.class);
        Assertions.assertEquals(3, dashboards.size());
        Assertions.assertTrue(dashboards.stream().anyMatch(s -> s.contains("demo.orderItems.json")));
        Assertions.assertTrue(dashboards.stream().anyMatch(s -> s.contains("Global.json")));
        Assertions.assertTrue(dashboards.stream().anyMatch(s -> s.contains("demo.orders.json")));
    }
}
