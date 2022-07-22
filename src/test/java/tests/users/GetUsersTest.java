package tests.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ServeRest;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUsersTest {

    private ServeRest serverest;

    @BeforeEach
    public void setUp() {
        serverest = new ServeRest();
    }

    @Test
    public void getUsersReturnsUsersList() {
        Response response = serverest.getUsers();
        response.prettyPrint();
        assertEquals(200, response.statusCode());
        assertThat(response.body().path("quantidade"), greaterThan(1));
    }
}
