package utils;

import java.io.*;
import java.util.Properties;

public class PropertyReader {

   static Properties properties = new Properties();
   static String filepath = System.getProperty("user.dir");

    public static String getValueOfKey(String key) throws Exception {

        InputStream inputStream = new FileInputStream(filepath+"/androidui/src/main/java/testData/dynamicData.properties");
        properties.load(inputStream);
        String value = properties.getProperty(key);
        return value;
    }
    public static void setValue(String key, String value) throws Exception {
        OutputStream outputStream = new FileOutputStream(filepath+"/androidui/src/main/java/testData/dynamicData.properties");
        properties.setProperty(key,value);
        properties.store(outputStream,null);
    }
}
