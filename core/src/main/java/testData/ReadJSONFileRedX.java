package testData;

import coreUtils.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.*;
import java.util.*;

public class ReadJSONFileRedX {

    private String module;
    public ReadJSONFileRedX(String module){
        this.module = module;
    }

    public List<String> getDeliveryDivisionsUnderZones(String zoneName) throws Exception {
        JSONParser jsonParser = new JSONParser();
        String filePath = CoreFileUtils.zonesJsonPath;
        FileReader reader= new FileReader(filePath);

        JSONObject outerObject = (JSONObject) jsonParser.parse(reader);
        JSONArray innerObject = (JSONArray) outerObject.get(zoneName);
        return innerObject;
    }

    public List<String> getSuburbs(String division_or_districts) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        String filePath = CoreFileUtils.suburbsJsonPath;
        FileReader reader= new FileReader(filePath);

        JSONObject zonesObject = (JSONObject) jsonParser.parse(reader);
        JSONArray divisions = (JSONArray)zonesObject.get(division_or_districts);
        return divisions;
    }

    public List<String> getOSD(String division_or_districts) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        String filePath = CoreFileUtils.OSDJsonPath;
        FileReader reader= new FileReader(filePath);

        JSONObject zonesObject = (JSONObject) jsonParser.parse(reader);
        JSONArray divisions = (JSONArray)zonesObject.get(division_or_districts);
        return divisions;
    }

    public List<String> getISD(String division_or_districts) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        String filePath = CoreFileUtils.ISDJsonPath;
        FileReader reader= new FileReader(filePath);

        JSONObject zonesObject = (JSONObject) jsonParser.parse(reader);
        JSONArray divisions = (JSONArray)zonesObject.get(division_or_districts);
        return divisions;
    }

    public List<String> getParcelID() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        String filePath = CoreFileUtils.ParcelIDJsonPath;
        FileReader reader= new FileReader(filePath);

        JSONObject ParcelIDObject = (JSONObject) jsonParser.parse(reader);
        JSONArray parcelIDs = (JSONArray)ParcelIDObject.get("parcelID");
        return parcelIDs;
    }




}
