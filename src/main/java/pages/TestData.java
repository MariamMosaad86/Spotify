package pages;

import com.github.javafaker.Faker;

public class TestData {
    private static final Faker faker = new Faker();
    public static final String FAKE_EMAIL = faker.internet().emailAddress();
}