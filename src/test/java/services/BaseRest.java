package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseRest {
    protected RequestSpecification requestSpec;

    public BaseRest() {
        this.requestSpec = new RequestSpecBuilder().
                setBaseUri("https://serverest.dev").
                setContentType(ContentType.JSON).
                build();
    }

    public Response get(String path) {
        return
            given()
                .spec(requestSpec)
            .when()
                .get(path);
    }

    public Response getWithParams(String path, String paramName, String param) {
        return
            given()
                .spec(requestSpec)
                .pathParam(paramName, param)
            .when()
                .get(path + "/{"+paramName+"}");
    }

    public Response post(String path, Object body) {
        return
            given()
                .spec(requestSpec)
                .body(body)
                .accept(ContentType.JSON)
            .when()
                .post(path);
    }
}
