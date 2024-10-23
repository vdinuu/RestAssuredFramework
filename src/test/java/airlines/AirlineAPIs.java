package airlines;

import io.restassured.response.Response;
import restutils.RestUtil;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {
    public Response createAirline(Map<String, Object> createAirlinePayload){
        return RestUtil.performPost((String) BaseTest.jsonData.get("createAirlineEndpoint"),
                createAirlinePayload, new HashMap<>());
    }
}
