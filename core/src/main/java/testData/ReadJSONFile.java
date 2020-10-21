package testData;

import coreUtils.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;


public class ReadJSONFile {

    private String module;
    public ReadJSONFile(String module){
        this.module = module;
    }

    public JSONArray getJSONFileData(String appName,String arrayKey) throws Exception{
        JSONParser jsonParser = new JSONParser();
        String filePath = CoreFileUtils.searchTermJsonPath;
        FileReader reader= new FileReader(filePath);

        JSONObject outerObject = (JSONObject) jsonParser.parse(reader);
        JSONObject app = (JSONObject)outerObject.get(appName);
        return(JSONArray)app.get(arrayKey);
    }

    public JSONArray getLocationData(String appName,String arrayKey) throws Exception {
        JSONParser jsonParser = new JSONParser();
        String filePath = CoreFileUtils.locationTermJsonPath;
        FileReader reader= new FileReader(filePath);

        JSONObject outerObject = (JSONObject) jsonParser.parse(reader);
        JSONObject app = (JSONObject)outerObject.get(appName);
        return(JSONArray)app.get(arrayKey);
    }
}
