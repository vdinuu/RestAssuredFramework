package airlines;

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

    public static Map<String, Object> getCreateAirlinePayloadMap(String id, String airlineName, String country,
                                                                 String logo, String slogan, String headQuarters,
                                                                 String website, String yearEstablished) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("_id", id);
        payload.put("name", airlineName);
        payload.put("country", country);
        payload.put("logo", logo);
        payload.put("slogan", slogan);
        payload.put("head_quaters", headQuarters);
        payload.put("website", website);
        payload.put("established", yearEstablished);
        return payload;
    }
}
