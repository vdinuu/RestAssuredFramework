package airlines;

import airlines.pojos.CreateAirline;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reporting.ExtentListener;

import java.io.IOException;

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
//        CreateAirline payload = Payloads.getCreateAirlinePayloadPojo();
        CreateAirline payload = new CreateAirline().toBuilder().name("Dinu").build();
        Response response = createAirline(payload);
        ObjectMapper objectMapper = new ObjectMapper();
        CreateAirline createResponse = objectMapper.readValue(response.getBody().asString(), CreateAirline.class);
        Assert.assertEquals(response.statusCode(), 200, "Airline is not created");
        Assert.assertEquals(payload, createResponse);
    }
}
