package openweb.POJO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import openweb.utils.JsonParser;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestData {

    String comment;
    String userName;

    public static TestData getTestData(final String jsonName) {
        return JsonParser.jsonToObject(jsonName, TestData.class);
    }
}
