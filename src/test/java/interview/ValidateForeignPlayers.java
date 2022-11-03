package interview;
import helper.BaseClass;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;

class RcbTeamPlayerValidation extends BaseClass {
    static int foreignPlayerCount=0;
    static int wicketKeeperCount=0;
    public static void main(String[] args) throws IOException, ParseException {
        JSONObject jsonObject=BaseClass.getJsonFile("/src/main/resources/TestData.json");
        JSONArray jsonArray = (JSONArray) jsonObject.get("player");
        validateForeignPlayer(jsonArray);
        validateWicketPlayer(jsonArray);
    }

    public static void validateWicketPlayer(JSONArray jsonArray){
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject test = (JSONObject) jsonArray.get(i);
            if(test.get("role").toString().equals("Wicket-keeper")) {
                wicketKeeperCount++;
            }
        }
        if(wicketKeeperCount>=1)
            System.out.println("Team has wicket Player : "+wicketKeeperCount);
        else
            System.out.println("Team don't have wicket player");

    }
    public static void validateForeignPlayer(JSONArray jsonArray){
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject test = (JSONObject) jsonArray.get(i);
            if(!test.get("country").toString().equals("India")) {
                foreignPlayerCount++;
            }
        }
        if(foreignPlayerCount==4)
            System.out.println("Team has only four foreign players : "+foreignPlayerCount);
        else
            System.out.println("Team has "+foreignPlayerCount+" foreign players");
    }
}

