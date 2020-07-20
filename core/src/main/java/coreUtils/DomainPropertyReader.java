package coreUtils;

import java.io.*;
import java.util.*;

public class DomainPropertyReader {

    static Properties properties = new Properties();
    static File f = new File(System.getProperty("user.dir"));
    static String filepath = f.getParent();

    public static String getValueOfKey(String key) throws Exception {
        InputStream inputStream = new FileInputStream(filepath+"/scriptProperties/domains.properties");
        properties.load(inputStream);
        return properties.getProperty(key);
    }



    public class Keys{
        public static final String RESELLER_APP_STAGE_BASE_URL = "RESELLER_APP_STAGE_BASE_URL";
        public static final String RESELLER_APP_PROD_BASE_URL = "RESELLER_APP_PROD_BASE_URL";
        public static final String MOKAM_APP_STAGE_BASE_URL = "MOKAM_APP_STAGE_BASE_URL";
        public static final String MOKAM_APP_PROD_BASE_URL = "MOKAM_APP_PROD_BASE_URL";
        public static final String RESELLER_WAP_STAGE_BASE_URL = "RESELLER_WAP_STAGE_BASE_URL";
        public static final String RESELLER_WEB_STAGE_BASE_URL = "RESELLER_WEB_STAGE_BASE_URL";
        public static final String MOKAM_WAP_STAGE_BASE_URL = "MOKAM_WAP_STAGE_BASE_URL";
        public static final String MOKAM_WEB_STAGE_BASE_URL = "MOKAM_WEB_STAGE_BASE_URL";
        public static final String RESELLER_WAP_PROD_BASE_URL = "RESELLER_WAP_PROD_BASE_URL";
        public static final String RESELLER_WEB_PROD_BASE_URL = "RESELLER_WEB_PROD_BASE_URL";
        public static final String MOKAM_WAP_PROD_BASE_URL = "MOKAM_WAP_PROD_BASE_URL";
        public static final String MOKAM_WEB_PROD_BASE_URL = "MOKAM_WEB_PROD_BASE_URL";
        public static final String WMS_WEB_STAGE_BASE_URL = "WMS_WEB_STAGE_BASE_URL";
        public static final String WMS_WEB_PROD_BASE_URL = "WMS_WEB_PROD_BASE_URL";
    }
}
