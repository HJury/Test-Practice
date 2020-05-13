package util;


import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class JSONNewCampaign {

   static JSONParser parser = new JSONParser();
   static Object object;

    {
        try {
            object = parser.parse(new FileReader(System.getProperty("user.dir") + "\\excel\\newCampaign.xlsx"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

   static JSONObject jsonObject = (JSONObject)object;

    static public String getValue(String name){
        return (String)jsonObject.get(name);
    }


}
