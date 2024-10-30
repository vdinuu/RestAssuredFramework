package restutils;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.response.Response;
import reporting.ExtentListener;
import reporting.ExtentReportsManager;

import java.util.*;

public class AssertionUtils {
    public static void assertExpectedValuesWithJsonPath(Response response, Map<String, Object> expectedValuesMap){
        List<AssertionKeys> actualValuesMap = new ArrayList<>();
        actualValuesMap.add(new AssertionKeys("JSON_PATH", "EXPECTED_VALUE", "ACTUAL_VALUE", "RESULT"));
        boolean allMatched = true;
        Set<String> jsonPaths = expectedValuesMap.keySet();
        for(String jsonPath: jsonPaths){
            Optional<Object> actualValue = Optional.ofNullable(response.jsonPath().get(jsonPath));
            if(actualValue.isPresent()){
                Object value = actualValue.get();
                if(value.equals(expectedValuesMap.get(jsonPath))){
                    actualValuesMap.add(new AssertionKeys(jsonPath, expectedValuesMap.get(jsonPath), value, "MATCHED"));
                } else{
                    allMatched = false;
                    actualValuesMap.add(new AssertionKeys(jsonPath, expectedValuesMap.get(jsonPath), value, "NOT MATCHED"));
                }
            } else{
                allMatched = false;
                actualValuesMap.add(new AssertionKeys(jsonPath, expectedValuesMap.get(jsonPath), "VALUE NOT FOUND", "NOT MATCHED"));
            }
        }
        if(allMatched){
            ExtentReportsManager.logPassDetails("All assertions are passed. 😊😊");
        }else{
            ExtentReportsManager.logFailureDetails("All assertions are NOT passed.");
        }
        String[][] finalAssertionsMap = actualValuesMap.stream().map(assertions -> new String[] {assertions.getJsonPath(), String.valueOf(assertions.getExpectedValue()),
                String.valueOf(assertions.getActualValue()), assertions.getResult()})
                .toArray(String[][] ::new);
        ExtentListener.extentTest.get().info(MarkupHelper.createTable(finalAssertionsMap));

    }
}
