package tests.users;

import factory.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ServeRest;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetUsersTest {

    private ServeRest serverest;

    @BeforeEach
    public void setUp() {
        serverest = new ServeRest();
    }

    @Test
    public void getUsersReturnsUsersList() {
        Response response = serverest.getUsers();
        response.prettyPeek();
        assertEquals(200, response.statusCode());
        assertThat(response.body().path("quantidade"), greaterThan(1));
    }

    @Test
    public void getsOneSpecificUser() {
        String createdUserId = serverest.createUser(Factory.randomUser(true)).body().path("_id");
        Response response = serverest.getUser(createdUserId);
        response.prettyPeek();
        assertEquals(200, response.statusCode());
        response.then().body(matchesJsonSchemaInClasspath("schemas/get_user_200.json"));
    }
}
