package auth.commerce;

import coreUtils.CoreFileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;

public class CredentialsReader {


    public static HashMap<String,String> getResellerCredentials(){
        HashMap<String,String> resellerCredentials =
                new HashMap<String,String>();
        try{
            Object obj1 = new JSONParser().parse(new FileReader(CoreFileUtils.commerceVerifyOtpJsonPath));
            JSONObject jo1 = (JSONObject) obj1;
            resellerCredentials.put("mobile",(String)((JSONObject)jo1.get("user")).get("phone"));
            resellerCredentials.put("otp",(String)((JSONObject)jo1.get("user")).get("otp"));
            return resellerCredentials;
        }catch (Exception e){
            System.out.println("Exception At Reading getResellerCredentials : CredentialsReader");
            return null;
        }
    }

}
