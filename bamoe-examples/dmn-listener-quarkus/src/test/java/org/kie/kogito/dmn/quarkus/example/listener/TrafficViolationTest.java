package org.kie.kogito.dmn.quarkus.example.listener;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class TrafficViolationTest {

    public static final String TRAFFIC_VIOLATION_TEST_BODY = "" +
            "{\n" +
            "    \"Driver\": {\n" +
            "        \"Points\": 2\n" +
            "    },\n" +
            "    \"Violation\": {\n" +
            "        \"Type\": \"speed\",\n" +
            "        \"Actual Speed\": 120,\n" +
            "        \"Speed Limit\": 100\n" +
            "    }\n" +
            "}";

    @Test
    public void testEvaluateTrafficViolation() {
        given()
                .body(TRAFFIC_VIOLATION_TEST_BODY)
                .contentType(ContentType.JSON)
                .when()
                .post("/Traffic Violation")
                .then()
                .statusCode(200)
                .body("'Should the driver be suspended?'", is("No"));
    }
}
