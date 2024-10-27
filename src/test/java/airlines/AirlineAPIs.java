package airlines;

import airlines.pojos.CreateAirline;
import io.restassured.response.Response;
import restutils.RestUtil;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {
    public Response createAirline(Map<String, Object> createAirlinePayload){
        return RestUtil.performPost((String) BaseTest.jsonData.get("createAirlineEndpoint"),
                createAirlinePayload, new HashMap<>());
    }
    public Response createAirline(CreateAirline createAirlinePayload){
        return RestUtil.performPost((String) BaseTest.jsonData.get("createAirlineEndpoint"),
                createAirlinePayload, new HashMap<>());
    }
}
