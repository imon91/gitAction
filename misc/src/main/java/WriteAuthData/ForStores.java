package WriteAuthData;

import com.opencsv.CSVWriter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;

public class ForStores {

    private static Response response;
    private static JSONObject jsonObject1;
    private static JSONObject jsonObject2;


    public static void main(String[] args) {
        RestAssured.baseURI = "https://uatstore.shopups2.xyz";
        Random random = new Random();
        int mobileNumber = random.nextInt();
        File file = new File(System.getProperty("user.dir"));
        String parentPath = file.getParent();
        try {
            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(parentPath+"/reseller_automation/misc/src/main/java/files/user_data.csv");

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputFile);

            // adding header to csv
            //String[] header = { "user" ,"mobile", "cookie" };
            //writer.writeNext(header);

            List<String[]> data = new ArrayList<String[]>();

            for(int i=231;i<=250;i++){
                String number = "88019"+((10000000+random.nextInt(1000000)+10));
                jsonObject1 = new JSONObject();
                jsonObject1.put("phone",number);
                // Send OTP
                //System.out.println(jsonObject1);
                response = given().header("Content-Type","application/json")
                        .body(jsonObject1.toJSONString()).post("/api/send_otp.json");
                //response.then().log().all();
                // Verify OTP
                jsonObject2 = new JSONObject();
                jsonObject2.put("phone",number);
                jsonObject2.put("otp","666666");
                //System.out.println(jsonObject2);
                response = given().header("Content-Type","application/json")
                        .body(jsonObject2.toJSONString()).post("/api/login.json");
                //response.then().log().all();

                String[] cookies = response.getHeader("Set-Cookie").split(";");

                data.add(new String[] { "user"+i, number, cookies[0] });
            }

            writer.writeAll(data);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
