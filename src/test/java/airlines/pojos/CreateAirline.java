package airlines.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import utils.RandomDataGenerator;
import utils.RandomDataTypes;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Overriding equals and hashcode method to compare two java pojo objects
@EqualsAndHashCode
@Builder(toBuilder = true)
//Json ignore used to ignore additional fields in respose which are not present in the request
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAirline {
    //To exclude comparision of one field- ID
    @EqualsAndHashCode.Exclude
    private int id = RandomDataGenerator.generateRandomNumber(6);
    private String name = RandomDataGenerator.generateRandomData(RandomDataTypes.FIRST_NAME);
    private String country = RandomDataGenerator.generateRandomData(RandomDataTypes.COUNTRY);
    private String logo = RandomDataGenerator.generateRandomData(RandomDataTypes.BRAND);
    private String slogan = RandomDataGenerator.generateRandomData(RandomDataTypes.BRAND);
    private City head_quaters = Arrays.stream(City.values()).findAny().get();
    private String website = RandomDataGenerator.generateRandomWebsite();
    private String established= String.valueOf(RandomDataGenerator.generateYear(1990, 2024));


}
