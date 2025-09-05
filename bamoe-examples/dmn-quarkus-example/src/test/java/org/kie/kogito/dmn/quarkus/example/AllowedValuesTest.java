package org.kie.kogito.dmn.quarkus.example;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class AllowedValuesTest {

    @Test
    public void testAllowedValuesWithValidValue() {
        given()
                .body("{\n" +
                        "  \"p1\": {\n" +
                        "    \"Name\": \"Joe\",\n" +
                        "    \"Interests\": [\n" +
                        "      \"Golf\"\n" +
                        "    ]\n" +
                        "  }\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("/AllowedValuesChecksInsideCollection")
                .then()
                .statusCode(200)
                .body("'MyDecision'", is("The Person Joe likes 1 thing(s)."));
    }

    @Test
    public void testAllowedValuesWithInvalidValue() {
        given()
                .body("{\n" +
                        "  \"p1\": {\n" +
                        "    \"Name\": \"Joe\",\n" +
                        "    \"Interests\": [\n" +
                        "      \"Dancing\"\n" +
                        "    ]\n" +
                        "  }\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("/AllowedValuesChecksInsideCollection")
                .then()
                .statusCode(500)
                .body("messages[0].message", containsString(
                        "Error while evaluating node 'MyDecision' for dependency 'p1': the dependency value '{Interests=[Dancing], Name=Joe}' is not allowed by the declared type (DMNType{ https://kie.apache.org/dmn/_E93F1115-55C7-4F4D-A81E-0C65833FC8D3 : Person })"));
    }
}
