package org.kie.kogito.examples.springboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.actuate.observability.AutoConfigureObservability;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = KogitoSpringbootApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureObservability
public class DroolsMetricsTest {

    private static final String PROJECT_VERSION = ProjectMetadataProvider.getProjectVersion();
    private static final String PROJECT_ARTIFACT_ID = ProjectMetadataProvider.getProjectArtifactId();

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    static {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testDrlMetrics() {
        given()
                .body("{\"strings\": [\"hello\"]}")
                .contentType(ContentType.JSON)
                .when()
                .post("/hello")
                .then()
                .statusCode(200);

        given()
                .when()
                .get("/actuator/prometheus")
                .then()
                .statusCode(200)
                .body(containsString(
                        String.format("drl_match_fired_nanosecond_count{app_id=\"default-rule-monitoring-listener\",artifactId=\"%s\",rule=\"helloWorld\",version=\"%s\"} 1", PROJECT_ARTIFACT_ID,
                                PROJECT_VERSION)));

        given()
                .when()
                .get("/actuator/prometheus")
                .then()
                .statusCode(200)
                .body(containsString("org_kie_kogito_examples_customruleeventlistener_total{event=\"afteractivationfiredeventimpl" +
                        "\"} 1.0"));
        given()
                .when()
                .get("/actuator/prometheus")
                .then()
                .statusCode(200)
                .body(containsString("org_kie_kogito_examples_customruleeventlistener_total{event=\"beforeactivationfiredeventimpl" +
                        "\"} 1.0"));
        given()
                .when()
                .get("/actuator/prometheus")
                .then()
                .statusCode(200)
                .body(containsString("org_kie_kogito_examples_customruleeventlistener_total{event=\"activationcreatedeventimpl" +
                        "\"} 1.0"));
    }
}
