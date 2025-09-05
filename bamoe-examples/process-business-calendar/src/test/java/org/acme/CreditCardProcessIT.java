package org.acme;

import org.junit.jupiter.api.Test;
import org.kie.kogito.calendar.BusinessCalendar;
import org.kie.kogito.process.ProcessConfig;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class CreditCardProcessIT {

    private static final String PROCESS_ID = "BusinessCalendarCreditBill";
    private static final String CARD_NUMBER = "434354343";

    @jakarta.inject.Inject
    ProcessConfig processConfig;

    @Test
    public void testCardPaymentInWorkingDay() throws Exception {
        String id = given()
                .contentType(ContentType.JSON)
                .body("{}")
                .when()
                .post("/" + PROCESS_ID)
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("creditCardDetails.cardNumber", is(CARD_NUMBER))
                .body("creditCardDetails.status", is("Bill Due"))
                .extract()
                .path("id");

        Thread.sleep(2000);
        BusinessCalendar businessCalendar = processConfig.getBusinessCalendar();
        assertThat(businessCalendar).isNotNull();
        long timeDuration = businessCalendar.calculateBusinessTimeAsDuration("15s");
        if (timeDuration > 1000L) {
            given()
                    .when()
                    .get("/" + PROCESS_ID + "/" + id)
                    .then()
                    .statusCode(200)
                    .body("id", is(id))
                    .body("creditCardDetails.cardNumber", is(CARD_NUMBER))
                    .body("creditCardDetails.status", is("Bill Due"));
        } else {
            given()
                    .when()
                    .get("/" + PROCESS_ID)
                    .then()
                    .statusCode(200)
                    .body(equalTo("[]"));
        }

    }
}
