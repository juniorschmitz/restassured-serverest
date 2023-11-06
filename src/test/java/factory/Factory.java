package factory;

import com.github.javafaker.Faker;
import java.util.Locale;
import model.User;

public class Factory {
    private static Faker faker = new Faker(Locale.UK);

    public static User randomUser(boolean administrador) {
        return new User(faker.name().fullName(),
                        faker.internet().emailAddress(),
                        faker.internet().password(),
                        administrador);
    }
}
