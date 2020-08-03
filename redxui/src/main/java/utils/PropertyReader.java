package utils;

import java.io.*;
import java.util.Properties;

public class PropertyReader {

    static Properties properties = new Properties();
    static String filepath = System.getProperty("user.dir");

    public static String getValueOfKey(String key) throws Exception
    {
        InputStream inputStream = new FileInputStream(filepath+"/src/main/java/testData/dynamicData.properties");
        properties.load(inputStream);
        return properties.getProperty(key);
    }


    public static void setValue(String key, String value) throws Exception
    {
        OutputStream outputStream = new FileOutputStream(filepath+"/src/main/java/testData/dynamicData.properties");
        properties.setProperty(key,value);
        properties.store(outputStream,null);
    }

    public class Keys
    {
        public static final String CUSTOMER_NAME = "CUSTOMEgit sR_NAME";
        public static final String CUSTOMER_PHONE = "CUSTOMER_PHONE";
        public static final String DELIVERY_ADDRESS = "DELIVERY_ADDRESS";
        public static final String DELIVERY_AREA = "DELIVERY_AREA";
        public static final String DELIVERY_INSTRUCTION = "DELIVERY_INSTRUCTION";
        public static final String INVOICE_NUMBER = "INVOICE_NUMBER";
        public static final String PARCEL_CASH = "PARCEL_CASH";
        public static final String PARCEL_SELLING_PRICE = "PARCEL_SELLING_PRICE";
        public static final String PARCEL_DATE = "PARCEL_DATE";
        public static final String PARCEL_ID = "PARCEL_ID";
        public static final String PARCEL_STATUS = "PARCEL_STATUS";
        public static final String PAYMENT_ID = "PAYMENT_ID";
        public static final String SHOP_NAME = "SHOP_NAME";
    }
}
