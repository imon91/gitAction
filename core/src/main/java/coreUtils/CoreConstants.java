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
    public static final String APP_PACKAGE = "com.shopup.reseller";;
    public static final String ANDROID_DEVICE_NAME =  "JagaEmulator";
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
    public static final String GROUP_FUNCTIONAL = "functional";
    public static final String GROUP_INTEGRATION = "integration";
    public static final String GROUP_REGRESSION = "regression";

    /*----------- WebUrls---------------*/
    public static final String RESELLER_STAGE_BASE_URL = "https://uatwap.shopups1.xyz/r";
    public static final String UNICORN_STAGE_BASE_URL = "https://ucwap.shopups1.xyz/r";
    public static final String UNICORN_PRODUCTION_BASE_URL = "https://ucwap.vnksrvc.com/";
    public static final String WMS_STAGE_BASE_URL = "https://uatwms.vnksrvc.com/";
}
