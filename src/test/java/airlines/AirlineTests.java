package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reporting.ExtentListener;

import java.util.Map;
@Listeners(ExtentListener.class)

public class AirlineTests extends AirlineAPIs {

    @Test
    public void createAirlineTest() {
        Map<String, Object> payload = Payloads.getCreateAirlinePayloadMap("252d3bca-d9bb-476c-9a97-562d685e235c","Sri Lankan Airways", "Sri Lanka",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png", "From Sri Lanka", "Katunayake, Sri Lanka",
                "www.srilankaaairways.com//", "1990");
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 200, "Airline is not created");
    }
}
