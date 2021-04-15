package coreUtils;

public class BuildParameterKeys {

    public static final String KEY_APP = "App";
    public static final String KEY_VERSION = "Version";
    public static final String KEY_ENV = "Env";
    public static final String KEY_DEVICE = "Device";
    public static final String KEY_Browser = "Br";
    public static final String KEY_BROWSER_VERSION = "BRv";
    public static final String KEY_OPERATING_SYSTEM = "Os";
    public static final String KEY_OPERATING_SYSTEM_VERSION = "OSv";
    public static final String KEY_HOST = "Host";
    public static final String KEY_TRIGGER = "Trigger";
    public static final String KEY_USER = "User";


    private final String keyTestRail = "TestRail";
    private final String keyService = "Service";

    public String getKeyService() {
        return keyService;
    }

    public String getServiceKeyValue(){
        return getSystemProperty(keyService);
    }

    public String getKeyTestRail() {
        return keyTestRail;
    }

    public String getTestRailKeyValue(){
        return getSystemProperty(keyTestRail);
    }


    public static String getKeyApp() {
        return KEY_APP;
    }

    public static String getKeyVersion() {
        return KEY_VERSION;
    }

    public static String getKeyEnv() {
        return KEY_ENV;
    }

    public static String getKeyDevice() {
        return KEY_DEVICE;
    }

    public static String getKEY_Browser() {
        return KEY_Browser;
    }

    public static String getKeyBrowserVersion() {
        return KEY_BROWSER_VERSION;
    }

    public static String getKeyOperatingSystem() {
        return KEY_OPERATING_SYSTEM;
    }

    public static String getKeyOperatingSystemVersion() {
        return KEY_OPERATING_SYSTEM_VERSION;
    }

    public static String getKeyHost() {
        return KEY_HOST;
    }

    public static String getKeyTrigger() {
        return KEY_TRIGGER;
    }

    public static String getKeyUser() {
        return KEY_USER;
    }

    private String getSystemProperty(String keyName){
        return System.getProperty(keyName);
    }
}
