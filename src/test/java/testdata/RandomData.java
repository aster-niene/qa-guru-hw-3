package testdata;

import com.github.javafaker.Faker;

import java.util.*;

public class RandomData {

    static Random random = new Random();
    static Faker faker = new Faker(new Locale ("en"));
    public static String
            firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            email = getRandomEmail(),
            phone = getRandomNumber(10),
            address = getRandomAddress(),
            subject = getRandomSubject(),

            birthDay = getRandomDay(),
            birthMonth = getRandomMonth(),
            birthYear = getRandomYear(),
            state = getRandomState(),
            city = getRandomCity(state);

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomNumber(int length) {
        return faker.number().digits(length);
    }

    public static String getRandomDay() {
        return String.valueOf(faker.number().numberBetween(1, 30));
    }

    public static String getRandomYear() {
        return String.valueOf(faker.number().numberBetween(1900, 2021));
    }

    public static String getRandomSubject() {
        String[] arraySubjects = {"Maths", "Arts", "Commerce", "Physics"};
        return arraySubjects[random.nextInt(arraySubjects.length)];
    }

    public static String getRandomMonth() {
        String[] arrayMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return arrayMonths[random.nextInt(arrayMonths.length)];
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        String[] arrayStates = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return arrayStates[random.nextInt(arrayStates.length)];
    }

    public static String getRandomCity(String key) {
        Map<String, String[]> mapStateAndCity = new HashMap<>();
        mapStateAndCity.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        mapStateAndCity.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        mapStateAndCity.put("Haryana", new String[]{"Karnal", "Panipat"});
        mapStateAndCity.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
        String[] arrayCities = mapStateAndCity.get(key);
        return arrayCities[random.nextInt(arrayCities.length)];
    }
}
