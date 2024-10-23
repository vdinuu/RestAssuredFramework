package airlines;

import utils.JsonUtils;

import java.util.Map;

public class BaseTest {
    public static Map<String, Object> jsonData;
    static {
        String env = System.getProperty("env") == null ? "qa": System.getProperty("env");
        jsonData = JsonUtils.getJsonDataAsMap("airlines/"+env+"/AirlineData.json");
    }
}
