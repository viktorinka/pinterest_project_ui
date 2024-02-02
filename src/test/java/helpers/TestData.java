package helpers;

import com.github.javafaker.Faker;
import config.AuthConfig;
import static org.aeonbits.owner.ConfigFactory.create;

public class TestData {
    private static AuthConfig authConfig = create(AuthConfig.class, System.getProperties());

    final public static String email = authConfig.email(),
            password = authConfig.password();
    public static String countryCode = "Russian Federation (+7)";
    public static String number = ("9824918041");
    static Faker faker = new Faker();
    public static String name = faker.name().firstName();
    public static String random = faker.chuckNorris().fact();
    public static String pronouns = faker.options().option("ey/em", "she/her", "he/him", "they/them", "ne/nem");
    public static String website = faker.internet().domainName();
}
