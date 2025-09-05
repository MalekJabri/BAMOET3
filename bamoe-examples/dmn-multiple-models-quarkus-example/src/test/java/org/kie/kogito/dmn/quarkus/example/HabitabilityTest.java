package org.kie.kogito.dmn.quarkus.example;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class HabitabilityTest {

    @Test
    public void testEvaluateHabitability() {
        given()
                .body("{\n" +
                        "  \"oxygene\": 70,\n" +
                        "  \"temperature\": 30\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("/habitability")
                .then()
                .statusCode(200)
                .body("'habitability'", is("somehow doable"));
    }
}
