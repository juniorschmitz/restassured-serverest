package services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.User;

import static io.restassured.RestAssured.given;

public class ServeRest {
    private RequestSpecification requestSpec;
    private String USERS_ROUTE = "/usuarios";

    public ServeRest() {
        this.requestSpec = new RequestSpecBuilder().
            setBaseUri("https://serverest.dev").
            setContentType(ContentType.JSON).
            build();
    }

    public Response getUsers() {
        return
            given()
                .spec(requestSpec)
            .when()
                .get(USERS_ROUTE);
    }

    public Response getUser(String id) {
        return
            given()
                .spec(requestSpec)
                .pathParam("id", id)
            .when()
                .get(USERS_ROUTE + "/{id}");
    }

    public Response createUser(User user) {
        System.out.println(user.toString());
        return
            given()
                .spec(requestSpec)
                .body(user)
                .accept(ContentType.JSON)
            .when()
                .post(USERS_ROUTE);
    }
}
