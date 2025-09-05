package org.kie.kogito.examples.quarkus;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusIntegrationTest
public class DroolsMetricsIT {

    private static final String PROJECT_VERSION = ProjectMetadataProvider.getProjectVersion();
    private static final String PROJECT_ARTIFACT_ID = ProjectMetadataProvider.getProjectArtifactId();

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
                .get("/q/metrics")
                .then()
                .statusCode(200)
                .body(containsString(
                        String.format("drl_match_fired_nanosecond_count{app_id=\"default-rule-monitoring-listener\",artifactId=\"%s\",rule=\"helloWorld\",version=\"%s\"} 1.0", PROJECT_ARTIFACT_ID,
                                PROJECT_VERSION)));

        given()
                .when()
                .get("/q/metrics")
                .then()
                .statusCode(200)
                .body(containsString("org_kie_kogito_examples_customruleeventlistener_total{event=\"afteractivationfiredeventimpl" +
                        "\"} 1.0"));
        given()
                .when()
                .get("/q/metrics")
                .then()
                .statusCode(200)
                .body(containsString("org_kie_kogito_examples_customruleeventlistener_total{event=\"beforeactivationfiredeventimpl" +
                        "\"} 1.0"));
        given()
                .when()
                .get("/q/metrics")
                .then()
                .statusCode(200)
                .body(containsString("org_kie_kogito_examples_customruleeventlistener_total{event=\"activationcreatedeventimpl" +
                        "\"} 1.0"));
    }
}
