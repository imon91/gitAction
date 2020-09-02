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

    public JSONArray getJSONFileData(String appName) throws Exception{
        JSONParser jsonParser = new JSONParser();
        String filePath = CoreFileUtils.searchTermJsonPath;
        FileReader reader= new FileReader(filePath);

        JSONObject outerObject = (JSONObject) jsonParser.parse(reader);
        return (JSONArray)outerObject.get(appName);
    }
}
