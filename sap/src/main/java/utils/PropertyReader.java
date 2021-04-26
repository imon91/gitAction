package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyReader {

    static Properties properties = new Properties();
    static String filepath = System.getProperty("user.dir");

    public static String getValueOfKey(String key) throws Exception
    {
        InputStream inputStream = new FileInputStream(filepath+"/src/main/resources/testData/dynamicData.properties");
        properties.load(inputStream);
        return properties.getProperty(key);
    }


    public static void setValue(String key, String value) throws Exception
    {
        OutputStream outputStream = new FileOutputStream(filepath+"/src/main/resources/testData/dynamicData.properties");
        properties.setProperty(key,value);
        properties.store(outputStream,null);
    }

    public class Keys
    {
        public static final String CUSTOMER_NAME = "CUSTOMER_NAME";
    }
}
