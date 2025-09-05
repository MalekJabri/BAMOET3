package org.kie.kogito.dmn.quarkus.example.dtlistener;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import jakarta.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasKey;

/**
 * This test will remain just-and-only a `@QuarkusTest` given the need of CDI injection to verify assertions.
 * This test does not need an IT equivalent, simply because the logic provided by the listener is not exposed as REST, for instance.
 */
@QuarkusTest
public class DecisionTableTest {
    static {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public static final String JSON_PAYLOAD_1 = "{\"a\": 47, \"b\": 47}";
    public static final String JSON_PAYLOAD_2 = "{\"a\": 0, \"b\": 0}";

    @Inject
    ExampleDMNRuntimeEventListener listener;

    @Test
    public void testEvents() {
        doRestCall(JSON_PAYLOAD_1);

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(() -> assertThat(listener.getEvents()).hasSize(2));

        doRestCall(JSON_PAYLOAD_2);

        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(() -> assertThat(listener.getEvents()).hasSize(4));

        // final await, giving opportunity as well to spot in logs.
        await().atMost(10, TimeUnit.SECONDS)
                .pollDelay(8, TimeUnit.SECONDS)
                .untilAsserted(() -> assertThat(listener.getEvents()).hasSizeGreaterThan(0));
    }

    private void doRestCall(String payload) {
        given()
                .body(payload)
                .contentType(ContentType.JSON)
                .when()
                .post("/dtevent")
                .then()
                .statusCode(200)
                .body("'my decision'", allOf(hasKey("e1"), hasKey("e2")));
    }
}
