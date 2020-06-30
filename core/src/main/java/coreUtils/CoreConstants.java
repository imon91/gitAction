package coreUtils;

public class CoreConstants {

    /*-----Global Constants-----*/
    public static final boolean TRUE = true;
    public static final boolean FALSE = false;

    /*----URL Components-----*/

    public static final String PROTOCOL = "http://";
    public static final int PORT = 4723;
    public static final String HOST = "127.0.0.1";
    public static final String WEB_DRIVER_AS_HUB = "/wd/hub";

    /*----------DesiredCapabilities Values---------*/

    public static final String PLATFORM_ANDROID = "Android";
    public static final String ANDROID_PLATFORM_VERSION = "9";
    public static final String RESELLER_APP_PACKAGE = "com.shopup.reseller";
    public static final String MOKAM_APP_PACKAGE = "com.mokam.app";
    public static final String ANDROID_DEVICE_NAME =  "ShopUpAndroidDevice";
    public static final String ANDROID_AUTOMATION_NAME = "UiAutomator2";
    public static final String ANDROID_MAIN_ACTIVITY = "com.shopup.reseller.MainActivity";
    public static final int ABD_EXEC_TIME_OUT = 50000;


    /*------App Contexts--------*/

    public static final String SHOP_UP_NATIVE_VIEW = "NATIVE_APP";
    public static final String CHROME_WEB_VIEW = "WEBVIEW_chrome";
    public static final String SHOP_UP_RESELLER_WEB_VIEW = "WEBVIEW_com.shopup.reseller";

    /*------Driver Constants----*/

    public static final String CHROME_DRIVER_81 = "chromedriver81";
    public static final String FIREFOX_DRIVER = "geckodriver";

    /*------TestNg Groups-------*/
    public static final String GROUP_SMOKE = "smoke";
    public static final String GROUP_SANITY = "sanity";
    public static final String GROUP_FUNCTIONAL = "functional";
    public static final String GROUP_INTEGRATION = "integration";
    public static final String GROUP_REGRESSION = "regression";

    /*----------- WebUrls---------------*/

    public static final String RESELLER_APP_STAGE_BASE_URL = "https://uatapi.shopups1.xyz/";
    public static final String RESELLER_APP_PROD_BASE_URL = "";
    public static final String MOKAM_APP_STAGE_BASE_URL = "https://ucapi.shopups1.xyz/";
    public static final String MOKAM_APP_PROD_BASE_URL = "https://ucapi.vnksrvc.com/";
    public static final String RESELLER_WAP_STAGE_BASE_URL = "https://uatwap.shopups1.xyz/";
    public static final String RESELLER_WEB_STAGE_BASE_URL = "https://uatwap.shopups1.xyz/";
    public static final String MOKAM_WAP_STAGE_BASE_URL = "https://ucwap.shopups1.xyz/";
    public static final String MOKAM_WEB_STAGE_BASE_URL = "";
    public static final String RESELLER_WAP_PROD_BASE_URL = "https://uatwap.vnksrvc.com/";
    public static final String RESELLER_WEB_PROD_BASE_URL = "https://uatwap.vnksrvc.com";
    public static final String MOKAM_WAP_PROD_BASE_URL = "https://ucwap.vnksrvc.com/";
    public static final String MOKAM_WEB_PROD_BASE_URL = "";
    public static final String WMS_WEB_STAGE_BASE_URL = "https://uatwms.vnksrvc.com/";
    public static final String WMS_WEB_PROD_BASE_URL = "https://uatwms.vnksrvc.com/";

    /*----------- Environments---------------*/
    public static final String APP_RESELLER = "Reseller";
    public static final String APP_MOKAM = "Mokam";
    public static final String APP_WMS = "Wms";
    public static final String ENV_STAGE = "Stage";
    public static final String ENV_PROD = "Prod";


    /*----- Modules -------*/
    public static final String MODULE_ANDROID_UI = "android";
    public static final String MODULE_MOBILE_WEB_UI = "wap";
    public static final String MODULE_WEB_UI = "web";
    public static final String MODULE_WMS_UI = "wms";

}
