package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.User;

import static io.restassured.RestAssured.given;

public class ServeRest extends BaseRest {
    private String USERS_ROUTE = "/usuarios";

    public ServeRest() {
        super();
    }

    public Response getUsers() {
        return get(USERS_ROUTE);
    }

    public Response getUser(String id) {
        return getWithParams(USERS_ROUTE, "id", id);
    }

    public Response createUser(User user) {
        System.out.println(user.toString());
        return post(USERS_ROUTE, user);
    }
}
