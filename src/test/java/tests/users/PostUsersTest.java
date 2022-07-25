package tests.users;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ServeRest;
import factory.Factory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PostUsersTest {
    private ServeRest serverest;

    @BeforeEach
    public void setUp() {
        serverest = new ServeRest();
    }

    @Test
    public void postCreatesNewUserNonAdmin() {
        Response response = serverest.createUser(Factory.randomUser(false));
        response.prettyPeek();
        assertEquals(201, response.statusCode());
        assertNotNull(response.body().path("_id"));
        assertEquals(response.body().path("message"), "Cadastro realizado com sucesso");
    }

    @Test
    public void postCreatesNewUserAdmin() {
        Response response = serverest.createUser(Factory.randomUser(true));
        response.prettyPeek();
        assertEquals(201, response.statusCode());
        assertNotNull(response.body().path("_id"));
        assertEquals(response.body().path("message"), "Cadastro realizado com sucesso");
    }
}
