package org.kie.kogito.examples;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class ProcessSagaIT {

    public static final String ORDER_ID = "03e6cf79-3301-434b-b5e1-d6899b5639aa";

    @Test
    public void testOrderSuccess() {
        String payload = "{\n" +
                "    \"orderId\": \"" + ORDER_ID + "\"\n" +
                "}";
        ExtractableResponse<Response> response = createOrder(payload);
        response.path("id");
        assertThat(response.<String> path("paymentResponse.type")).isEqualTo("SUCCESS");
        assertThat(response.<String> path("stockResponse.type")).isEqualTo("SUCCESS");
        assertThat(response.<String> path("shippingResponse.type")).isEqualTo("SUCCESS");
        assertThat(response.<String> path("orderResponse.type")).isEqualTo("SUCCESS");
        assertThat(response.<String> path("orderResponse.resourceId")).isEqualTo(ORDER_ID);
    }

    @Test
    public void testOrderFailure() {
        String payload = "{\n" +
                "    \"orderId\": \"" + ORDER_ID + "\",\n" +
                "    \"failService\" : \"ShippingService\"\n" +
                "}";
        ExtractableResponse<Response> response = createOrder(payload);
        response.path("id");
        assertThat(response.<String> path("stockResponse.type")).isEqualTo("SUCCESS");
        assertThat(response.<String> path("paymentResponse.type")).isEqualTo("SUCCESS");
        assertThat(response.<String> path("shippingResponse.type")).isEqualTo("ERROR");
        assertThat(response.<String> path("orderResponse.type")).isEqualTo("ERROR");
        assertThat(response.<String> path("orderResponse.resourceId")).isEqualTo(ORDER_ID);
    }

    private ExtractableResponse<Response> createOrder(String payload) {
        ExtractableResponse<Response> response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post("/order")
                .then()
                .statusCode(201)
                .header("Location", notNullValue())
                .extract();
        return response;
    }
}
