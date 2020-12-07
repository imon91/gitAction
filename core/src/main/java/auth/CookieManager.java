package auth;

import coreUtils.CoreFileUtils;

import java.io.*;
import java.util.Properties;

public class CookieManager {


    static Properties properties = new Properties();
    static String propertiesFilePath = CoreFileUtils.cookiePropertiesFilePath;

    public static String getValueOfKey(String key) throws Exception {
        InputStream inputStream = new FileInputStream(propertiesFilePath);
        properties.load(inputStream);
        return properties.getProperty(key);
    }


    public static void setValue(String key, String value) throws Exception {
        FileInputStream inputStream = new FileInputStream(propertiesFilePath);
        properties.load(inputStream);
        inputStream.close();

        OutputStream outputStream = new FileOutputStream(propertiesFilePath);
        properties.setProperty(key, value);
        properties.store(outputStream, null);
        outputStream.close();
    }


    public class Keys {
        public static final String WMS_COOKIE = "WMS_COOKIE";
        public static final String RESELLER_COOKIE = "RESELLER_COOKIE";
        public static final String MOKAM_COOKIE = "MOKAM_COOKIE";
        public static final String RED_X_COOKIE = "RED_X_COOKIE";
        public static final String STORE_WAP_COOKIE = "STORE_WAP_COOKIE";
        public static final String WMS_SESSION = "WMS_SESSION";
        public static final String STORE_APP_COOKIE = "STORE_APP_COOKIE";
        public static final String SAP_WEB_COOKIE = "SAP_WEB_COOKIE";
    }

}
