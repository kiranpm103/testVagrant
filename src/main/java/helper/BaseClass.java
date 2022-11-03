package helper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class BaseClass {
    public static JSONObject getJsonFile(String path) throws IOException, ParseException {
        FileReader reader =new FileReader(System.getProperty("user.dir") +path);
        return (JSONObject) new JSONParser().parse(reader);
    }

}
