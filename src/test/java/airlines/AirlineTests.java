package airlines;

import airlines.pojos.CreateAirline;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reporting.ExtentListener;
import restutils.AssertionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Listeners(ExtentListener.class)

public class AirlineTests extends AirlineAPIs {

    @Test
    public void createAirlineTest() {
//        CreateAirline payload = Payloads.getCreateAirlinePayloadPojo();
        CreateAirline payload = new CreateAirline().toBuilder().name("Dinu").build();
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 200, "Airline is not created");
    }
    @Test
    public void createAirlineValidationTest() throws IOException {
        CreateAirline payload = new CreateAirline().toBuilder().name("Dinu").build();
        Response response = createAirline(payload);
        ObjectMapper objectMapper = new ObjectMapper();
        CreateAirline createResponse = objectMapper.readValue(response.getBody().asString(), CreateAirline.class);
        Assert.assertEquals(response.statusCode(), 200, "Airline is not created");
        Assert.assertEquals(payload, createResponse);
    }
    @Test
    public void createAirlineValidation()  {
        CreateAirline request = Payloads.getCreateAirlinePayloadPojo();
        Response response = createAirline(request);
        Map<String, Object> expectedValueMap = new HashMap<>();
//        expectedValueMap.put("id", request.getId());
        expectedValueMap.put("name", request.getName());
        expectedValueMap.put("country", request.getCountry());
        expectedValueMap.put("logo", request.getLogo());
        expectedValueMap.put("slogan", request.getSlogan());
        expectedValueMap.put("head_quaters", request.getHead_quaters());
        expectedValueMap.put("website", request.getWebsite());
        expectedValueMap.put("established", request.getEstablished());
        AssertionUtils.assertExpectedValuesWithJsonPath(response, expectedValueMap);
    }
}
