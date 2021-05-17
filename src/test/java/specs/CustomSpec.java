package specs;

import config.ConfigHelper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class CustomSpec {
    private final RequestSpecification request = given()
            .baseUri(ConfigHelper.getBaseURL())
            .basePath("repos/testaqa/qaguru_hw18")
            .filter(new AllureRestAssured().setRequestTemplate("request.ftl").setResponseTemplate("response.ftl"))
            .log().uri()
            .when();

    private final ResponseSpecification response = expect()
            .statusCode(200)
            .body("number", notNullValue())
            .body("title", notNullValue())
            .body("body", notNullValue());

    public static CustomSpec spec() {
        return new CustomSpec();
    }

    public RequestSpecification request() {
        return request;
    }

    public ResponseSpecification response() {
        return response;
    }
}
