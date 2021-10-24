package openweb.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.thucydides.core.util.TestResources;

import java.io.File;
import java.io.IOException;

public class JsonParser {

    private JsonParser() {
    }

    public static <T> T jsonToObject(final String fileName, final Class<T> clazz) {
        File file = TestResources.fileInClasspathCalled(fileName);
        ObjectMapper mapper = new ObjectMapper();
        T obj = null;
        try {
            mapper.readTree(file);
            obj = mapper.readValue(file, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
