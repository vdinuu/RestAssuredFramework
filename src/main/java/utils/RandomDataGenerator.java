package utils;

import net.datafaker.Faker;

public class RandomDataGenerator {
    public static Faker faker = new Faker();

    public static String generateRandomData(RandomDataTypes randomDataTypes){
        return switch (randomDataTypes){
            case FIRST_NAME -> faker.name().firstName();
            case LAST_NAME ->  faker.name().lastName();
            case FULL_NAME -> faker.name().fullName();
            case COUNTRY -> faker.address().country();
            case CITY -> faker.address().city();
            case BRAND -> faker.commerce().brand();
        };
    }
    public static int generateRandomNumber(int digitCount){
        return Integer.parseInt(faker.number().digits(digitCount));
    }
    public static String generateRandomWebsite(){
       return "https://"+faker.commerce().brand()+".com";
    }
    public static int generateYear(int beginYear, int endYear){
        return faker.number().numberBetween(beginYear, endYear);
    }
}
