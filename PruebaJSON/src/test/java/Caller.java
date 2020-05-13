import org.json.simple.parser.ParseException;
import utils.JsonReader;
import utils.PropertiesReader;

import java.io.IOException;

public class Caller {
    public static void main(String[] args) throws IOException, ParseException {
        PropertiesReader propertiesReader = new PropertiesReader();
        String algo = propertiesReader.getPropoValues("JsonPath");
        System.out.println(algo);
        JsonReader.getValue("nara");
    }
}
