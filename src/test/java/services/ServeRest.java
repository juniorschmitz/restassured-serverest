package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ServeRest {
    private RequestSpecification requestSpec;

    public ServeRest() {
        this.requestSpec = new RequestSpecBuilder().
            setBaseUri("https://serverest.dev").
            setContentType(ContentType.JSON).
            build();
    }

    public Response getUsers() {
        return
            given().
                spec(requestSpec).
            when().
                get("/usuarios");
    }
}
