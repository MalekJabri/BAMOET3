package org.kie.kogito.dmn.consumer.example;

import org.junit.jupiter.api.Test;
import org.kie.kogito.decision.DecisionModel;
import org.kie.kogito.decision.DecisionModels;
import org.kie.kogito.dmn.DmnDecisionModel;
import org.kie.kogito.dmn.consumer.example.customprofiles.CustomDMNProfile;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class TrafficViolationTest {

    @jakarta.inject.Inject
    DecisionModels decisionModels;

    @Test
    public void testEvaluateTrafficViolation() {
        given()
                .body("{\n" +
                        "    \"Driver\": {\n" +
                        "        \"Points\": 2\n" +
                        "    },\n" +
                        "    \"Violation\": {\n" +
                        "        \"Type\": \"speed\",\n" +
                        "        \"Actual Speed\": 120,\n" +
                        "        \"Speed Limit\": 100\n" +
                        "    }\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("/Traffic Violation")
                .then()
                .statusCode(200)
                .body("'Should the driver be suspended?'", is("No"));
    }

    @Test
    void testCustomDMNProfile() {
        assertThat(decisionModels).isNotNull();
        DecisionModel decisionModel = decisionModels.getDecisionModel("https://kie.apache.org/dmn/_CDBA94FB-C0A8-46D0-ABC2-686ED6BD14DD", "Traffic Violation");
        assertThat(decisionModel).isNotNull().isInstanceOf(DmnDecisionModel.class);
        DmnDecisionModel dmnDecisionModel = (DmnDecisionModel) decisionModel;
        assertThat(dmnDecisionModel).isNotNull();
        assertThat(dmnDecisionModel.getProfiles()).anyMatch(profile -> profile instanceof CustomDMNProfile);
    }
}
