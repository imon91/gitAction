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
    public static final String RESELLER_APP_PACKAGE = "com.shopup.reseller.debug";
    public static final String MOKAM_APP_PACKAGE = "com.mokam.app.debug";
    public static final String RED_X_APP_PACKAGE = "com.redx.delivery";
    public static final String ANDROID_DEVICE_NAME =  "ShopUpAndroidDevice";
    public static final String ANDROID_AUTOMATION_NAME = "UiAutomator2";
    public static final String ANDROID_MAIN_ACTIVITY = "com.shopup.reseller.MainActivity";
    public static final String ANDROID_REGISTRATION_PAGE_ACTIVITY = "com.shopup.registration.RegistrationActivity";
    public static final String ANDROID_PROFILE_ACTIVITY = "com.shopup.profile.ProfileActivity";
    public static final String ANDROID_HOME_ACTIVITY = "com.shopup.reseller.HomeActivity";
    public static final String ANDROID_SALES_REP_LIST_ACTIVITY = "com.shopup.salesrep.ListRetailersActivity";
    public static final String RED_X_SPLASH_ACTIVITY = "com.redx.delivery.SplashActivity";
    public static final int ABD_EXEC_TIME_OUT = 50000;


    /*------App Contexts--------*/

    public static final String SHOP_UP_NATIVE_VIEW = "NATIVE_APP";
    public static final String CHROME_WEB_VIEW = "WEBVIEW_chrome";
    public static final String SHOP_UP_RESELLER_WEB_VIEW = "WEBVIEW_com.shopup.reseller.debug";
    public static final String SHOP_UP_MOKAM_WEB_VIEW = "WEBVIEW_com.mokam.app.debug";

    /*------Driver Constants----*/

    public static final String CHROME_DRIVER_81 = "chromedriver81";
    public static final String FIREFOX_DRIVER = "geckodriver";

    /*------TestNg Groups-------*/
    public static final String GROUP_SMOKE = "smoke";
    public static final String GROUP_SANITY = "sanity";
    public static final String GROUP_FUNCTIONAL = "functional";
    public static final String GROUP_INTEGRATION = "integration";
    public static final String GROUP_REGRESSION = "regression";

    /*----------- Environments---------------*/
    public static final String APP_RESELLER = "Reseller";
    public static final String APP_MOKAM = "Mokam";
    public static final String APP_WMS = "Wms";
    public static final String APP_RED_X = "RedX";
    public static final String APP_STORE = "Store";
    public static final String ENV_STAGE = "Stage";
    public static final String ENV_PROD = "Prod";
    public static final String MOKAM_RETAILER = "Retailer";
    public static final String MOKAM_USER = "SR";
    public static final String MOKAM_DSR_USER = "DSR";
    public static final String APP_STORES = "Stores";
    public static final String APP_SAP = "Sap";


    /*----- Modules -------*/
    public static final String MODULE_ANDROID_UI = "android";
    public static final String MODULE_MOBILE_WEB_UI = "wap";
    public static final String MODULE_WEB_UI = "web";
    public static final String MODULE_WMS_UI = "wms";
    public static final String MODULE_STORE_WAP = "store";
    public static final String MODULE_SAP_UI = "sap";

}
