package openweb.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import openweb.utils.JsonParser;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestData {

    String comment;
    String userName;
    String name;
    String email;
    String password;
    String live;
    String aboutYou;

    public static TestData getTestData(final String jsonName) {
        return JsonParser.jsonToObject(jsonName, TestData.class);
    }

    @JsonProperty
    public void setEmail(final String value) {
        this.email = RandomStringUtils.randomAlphabetic(6) + "@gmail.com";
    }
}
