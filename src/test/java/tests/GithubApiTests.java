package tests;

import config.ConfigHelper;
import io.qameta.allure.restassured.AllureRestAssured;
import models.Issue;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.CustomSpec;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GithubApiTests {

    int issueId = 1;
    String issueTitle = "Test Issue Title Here";
    String issueBody = "Some issue description";

    @Test
    @Tag("api")
    void getGithubIssueApiTest() {
        Issue response = given()
                .baseUri(ConfigHelper.apiConfig.apiUrl())
                .basePath("repos/testaqa/qaguru_hw18")
                .filter(new AllureRestAssured().setRequestTemplate("request.ftl").setResponseTemplate("response.ftl"))
                .log().uri()
                .when()
                .get("/issues/{issue}", issueId)
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .as(Issue.class);

        assertThat(response.getNumber(), is(issueId));
        assertThat(response.getTitle(), is(issueTitle));
        assertThat(response.getBody(), is(issueBody));
    }

    @Test
    @Tag("api")
    void getGithubIssueWithSpecApiTest() {
        Issue response = CustomSpec.spec().request()
                .get("/issues/{issue}", issueId)
                .then()
                .log().body()
                .spec(CustomSpec.spec().response())
                .extract()
                .as(Issue.class);

        assertThat(response.getNumber(), is(issueId));
        assertThat(response.getTitle(), is(issueTitle));
        assertThat(response.getBody(), is(issueBody));
    }

}
