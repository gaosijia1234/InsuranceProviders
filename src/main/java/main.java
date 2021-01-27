import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException, ParseException {
        Map<String, String> map = new HashMap<>();
        map.put("last_name", "Gray");
        map.put("locations", "Campbell");

        JSONParser jsonParser = new JSONParser();
        List<Object> lastNameList = new ArrayList<>();
        List<Object> cityList = new ArrayList<>();
        List<Object> firstNameList = new ArrayList<>();

        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("src/main/java/providers.json"));

        System.out.println("reading file");

        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;

            if(map.containsKey("last_name")) {
                lastNameList = getValue(map, "last_name", object);
//                String lastName = (String) jsonObject.get("last_name");
//                if (lastName.equals(map.get("last_name"))) {
//                    lastNameList.add(object);
//                }

            }
            if(map.containsKey("locations")){
                JSONArray locations = (JSONArray) jsonObject.get("locations");
                for (Object c : locations) {
                    JSONObject location = (JSONObject) c;
                    String city = (String) location.get("city");

                    if (city.equals(map.get("locations"))) {
                        cityList.add(object);
                    }
                }
            }
            if(map.containsKey("first_name")) firstNameList = getValue(map, "first_name", object);

        }
        System.out.println(lastNameList);
        System.out.println("-----------------");
        System.out.println(cityList);
        System.out.println("-----------------");
        System.out.println(firstNameList);
        //        return lastNameList;

    }
    // todo remove static
    public static List<Object> getValue(Map<String, String> map, String field, Object object){
        List<Object> list = new ArrayList<>();

        JSONObject jsonObject = (JSONObject) object;

        String lastName = (String) jsonObject.get(field);
        if (lastName.equals(map.get(field))) {
            list.add(object);
        }
        return list;
    }


}



