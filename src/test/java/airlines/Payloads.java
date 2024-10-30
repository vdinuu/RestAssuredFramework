package airlines;

import airlines.pojos.City;
import airlines.pojos.CreateAirline;
import utils.RandomDataGenerator;
import utils.RandomDataTypes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static String getCreateAirlinePayloadString(String id, String airlineName, String country,
                                                       String logo, String slogan, String headQuarters,
                                                       String website, String yearEstablished) {
        return "{\n" +
                "    \"_id\":\"" + id + "\",\n" +
                "    \"name\": \"" + airlineName + "\",\n" +
                "    \"country\": \"" + country + "\",\n" +
                "    \"logo\": \"" + logo + "\",\n" +
                "    \"slogan\": \"" + slogan + "\",\n" +
                "    \"head_quaters\": \"" + headQuarters + "\",\n" +
                "    \"website\": \"" + website + "\",\n" +
                "    \"established\": \"" + yearEstablished + "\"\n" +
                "}";
    }

    public static Map<String, Object> getCreateAirlinePayloadMap() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("_id", RandomDataGenerator.generateRandomNumber(10));
        payload.put("name", RandomDataGenerator.generateRandomData(RandomDataTypes.FIRST_NAME));
        payload.put("country", RandomDataGenerator.generateRandomData(RandomDataTypes.COUNTRY));
        payload.put("logo", RandomDataGenerator.generateRandomData(RandomDataTypes.BRAND));
        payload.put("slogan", RandomDataGenerator.generateRandomData(RandomDataTypes.BRAND));
        payload.put("head_quaters", RandomDataGenerator.generateRandomData(RandomDataTypes.CITY));
        payload.put("website", RandomDataGenerator.generateRandomWebsite());
        payload.put("established", RandomDataGenerator.generateYear(1990, 2024));
        return payload;
    }

    public static CreateAirline getCreateAirlinePayloadPojo() {
        return CreateAirline.builder()
                .id(RandomDataGenerator.generateRandomNumber(6))
                .name(RandomDataGenerator.generateRandomData(RandomDataTypes.FIRST_NAME))
                .country(RandomDataGenerator.generateRandomData(RandomDataTypes.COUNTRY))
                .logo(RandomDataGenerator.generateRandomData(RandomDataTypes.BRAND))
                .slogan(RandomDataGenerator.generateRandomData(RandomDataTypes.BRAND))
                .head_quaters(Arrays.stream(City.values()).findAny().get().name())
                .website(RandomDataGenerator.generateRandomWebsite())
                .established(String.valueOf(RandomDataGenerator.generateYear(1990, 2024)))
                .build();
    }
}
