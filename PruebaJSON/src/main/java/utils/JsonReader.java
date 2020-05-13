package utils;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    static PropertiesReader propertiesReader;

    static public String getValue(String value) throws IOException, ParseException {
        propertiesReader = new PropertiesReader();
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(propertiesReader.getPropoValues("JsonPath")+ "/CampaingInfo.json" );
       // Object obj = jsonParser.parse(reader);
       // JSONArray usersList = (JSONArray) obj;
       // System.out.println(usersList);
        JSONObject obj = (JSONObject) jsonParser.parse(reader);
        System.out.println(obj);
        JSONObject obj2 = (JSONObject) obj.get("Create Campaign");
        System.out.println(obj2);
        String dato = (String)obj2.get("Name");
        System.out.println(dato);
//        for (int i = 0; i < usersList.size(); i++) {
//
//            JSONObject users = (JSONObject) usersList.get(i);
//            System.out.println(users);//This prints every block - one json object
//            JSONObject user = (JSONObject) users.get("users");
//            System.out.println(user); //This prints each data in the block
//            String username = (String) user.get("username");
//            String password = (String) user.get("password");
//            System.out.println("The username in JSON is -> " + username);
//            System.out.println("The password in JSON is -> " + password);
//        }
        return "nara";
    }
}
