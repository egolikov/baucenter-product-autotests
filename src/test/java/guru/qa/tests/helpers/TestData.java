package guru.qa.tests.helpers;

import com.github.javafaker.Faker;

public class TestData {

    private final Faker faker;

    public TestData() {
        faker = new Faker();
    }

    public String generateRandomPassword() {
        return faker.internet().password();
    }

    public String generateRandomPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }
}
