package org.kie.kogito.traffic;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class TrafficProcessIT {

    public static final BigDecimal SPEED_LIMIT = new BigDecimal(100);

    @Test
    public void testTrafficViolationRestWIHDecisionOnQuarkus() {
        testTrafficProcess("traffic_wih", "12345", 120d, "No", true);
        testTrafficProcess("traffic_wih", "12345", 140d, "Yes", true);
        testTrafficProcess("traffic_wih", "1234", 140d, null, false);
    }

    @Test
    public void testTrafficViolationRestServiceDecisionOnQuarkus() {
        testTrafficProcess("traffic_service", "12345", 120d, "No", true);
        testTrafficProcess("traffic_service", "12345", 140d, "Yes", true);
        testTrafficProcess("traffic_service", "1234", 140d, null, false);
    }

    private void testTrafficProcess(String processId, String driverId, Double speed, String suspended, Boolean validLicense) {
        Map<String, Object> request = new HashMap<>();
        request.put("driverId", driverId);
        request.put("violation", new Violation("speed", SPEED_LIMIT, new BigDecimal(speed)));
        given()
                .body(request)
                .contentType(ContentType.JSON)
                .when()
                .post("/" + processId)
                .then()
                .statusCode(201)
                .body("trafficViolationResponse.Suspended", is(suspended))
                .body("driver.validLicense", is(validLicense));
    }
}
