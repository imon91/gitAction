package utils;

import java.io.*;
import java.util.*;

public class PropertyReader {

   static Properties properties = new Properties();
   static String filepath = System.getProperty("user.dir");

    public static String getValueOfKey(String key) throws Exception {
        InputStream inputStream = new FileInputStream(filepath+"/src/main/java/testData/dynamicData.properties");
        properties.load(inputStream);
        return properties.getProperty(key);
    }


    public static void setValue(String key, String value) throws Exception {
        FileInputStream inputStream = new FileInputStream(filepath+"/src/main/java/testData/dynamicData.properties");
        properties.load(inputStream);
        inputStream.close();

        OutputStream outputStream = new FileOutputStream(filepath+"/src/main/java/testData/dynamicData.properties");
        properties.setProperty(key, value);
        properties.store(outputStream, null);
        outputStream.close();
    }


    public static void flushDynamicData() throws Exception{
        setValue(Keys.SEARCH_TERM,"");
        setValue(Keys.CATEGORY_TYPE,"");
        setValue(Keys.VALID_PRODUCT_INDEX,"");
        setValue(Keys.VALID_SIZE_INDEX,"");
        setValue(Keys.VALID_PRODUCT_NAME,"");
        setValue(Keys.VALID_PRODUCT_SLUG,"");
        setValue(Keys.PLP_VIEW_TYPE,"");
        setValue(Keys.SORT_APPLIED,"False");
        setValue(Keys.SORT_VALUE,"");
        setValue(Keys.FILTER_APPLIED,"False");
        setValue(Keys.FILTER_VALUE,"");
        setValue(Keys.FILTER_KEY,"");
        setValue(Keys.FILTER_VALUE_ID,"");
        setValue(Keys.SORT_INDEX,"");
        setValue(Keys.PRODUCT_MAX_QUANTITY,"");
        setValue(Keys.PRODUCT_MIN_QUANTITY,"");
        setValue(Keys.ORDER_NUMBER,"");
    }


    public class Keys{
        public static final String SEARCH_TERM = "SEARCH_TERM";
        public static final String CATEGORY_TYPE = "CATEGORY_TYPE";
        public static final String VALID_PRODUCT_INDEX = "VALID_PRODUCT_INDEX";
        public static final String VALID_SIZE_INDEX = "VALID_SIZE_INDEX";
        public static final String VALID_PRODUCT_Details = "VALID_PRODUCT_Details";
        public static final String VALID_PRODUCT_NAME = "VALID_PRODUCT_NAME";
        public static final String VALID_PRODUCT_SLUG = "VALID_PRODUCT_SLUG";
        public static final String PLP_VIEW_TYPE = "PLP_VIEW_TYPE";
        public static final String SORT_APPLIED = "SORT_APPLIED";
        public static final String SORT_VALUE = "SORT_VALUE";
        public static final String FILTER_APPLIED = "FILTER_APPLIED";
        public static final String FILTER_VALUE = "FILTER_VALUE";
        public static final String FILTER_KEY = "FILTER_KEY";
        public static final String FILTER_VALUE_ID = "FILTER_VALUE_ID";
        public static final String SORT_INDEX = "SORT_INDEX";
        public static final String PRODUCT_MAX_QUANTITY = "PRODUCT_MAX_QUANTITY";
        public static final String PRODUCT_MIN_QUANTITY = "PRODUCT_MIN_QUANTITY";
        public static final String COD_ENABLED_VALID_SIZE_PRODUCT_NAME = "COD_ENABLED_VALID_SIZE_PRODUCT_NAME";
        public static final String ORDER_NUMBER = "ORDER_NUMBER";
    }
}
