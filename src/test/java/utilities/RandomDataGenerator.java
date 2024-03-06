package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

    // Generates a random first name
    public static String randomFirstName() {
        return "First" + RandomStringUtils.randomAlphabetic(5);
    }

    // Generates a random last name
    public static String randomLastName() {
        return "Last" + RandomStringUtils.randomAlphabetic(5);
    }

    // Generates a random email address
    public static String randomEmail() {
        String accountName = RandomStringUtils.randomAlphabetic(6);
        return accountName + "@test.com";
    }
}
