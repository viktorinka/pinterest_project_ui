package helpers;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    public static String email = "dzherommo@gmail.com";
    public static String password = "496188@COM";
    static Faker faker = new Faker();
    public static String name = faker.name().firstName();
    public static String random = faker.chuckNorris().fact();
    public static String pronouns = faker.options().option("ey/em", "she/her", "he/him", "they/them", "ne/nem");
    public static String website = faker.internet().domainName();
    public static String username = faker.name().name();
    public static String code = faker.address().country();
    public static String number = faker.phoneNumber().subscriberNumber(10);
    public static String address = faker.address().streetName();
    public static String city = faker.address().cityName();
    public static String state = faker.address().state();
    public static String postcode = faker.address().zipCode();
    public static String country = faker.options().option("Angola", "Bahamas", "Guyana", "Mali", "Zimbabwe");
}
