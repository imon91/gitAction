package utils;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import coreUtils.DomainPropertyReader;
import helper.GetDriverFromCore;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StoreWapBaseClass extends GetDriverFromCore{

    private static final String HOST_LOCAL = "local";
    private static final String HOST_BROWSER_STACK = "bs";
    private static AndroidDriver<WebElement> driver = null;
    private static final String host = System.getProperty("Host");



    public static AndroidDriver<WebElement> getBaseDriver() throws Exception{
        if(driver==null){
            setUpDriver();
        }
        return  driver;
    }


    public static String getWAPBaseUrl() throws Exception {
        String env = System.getProperty(BuildParameterKeys.KEY_ENV);
        String app = System.getProperty(BuildParameterKeys.KEY_APP);
        if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)
                && env.equalsIgnoreCase(CoreConstants.ENV_STAGE)) {
            return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.STORE_WAP_STAGE_BASE_URL);
        } else if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)
                && env.equalsIgnoreCase(CoreConstants.ENV_PROD)) {
            return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.STORE_WAP_PROD_BASE_URL);
        }else {
            // Default is STAGE
            return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.STORE_WAP_STAGE_BASE_URL);
        }
    }


    private static void setUpDriver()throws Exception{
        if (host.equalsIgnoreCase(HOST_LOCAL)) {
            startService();
            driver = GetDriverFromCore.getAndroidDriverForChrome(null,null,host,null,null);
        }else if(host.equalsIgnoreCase(HOST_BROWSER_STACK)){
            String device = System.getProperty(BuildParameterKeys.KEY_DEVICE);
            String deviceVersion = System.getProperty(BuildParameterKeys.KEY_VERSION);
            String browser = System.getProperty(BuildParameterKeys.KEY_Browser);
            String browserVersion = System.getProperty(BuildParameterKeys.KEY_BROWSER_VERSION);
            driver = GetDriverFromCore.getAndroidDriverForChrome(device,deviceVersion,host,browser,browserVersion);
        }else {
            System.out.println(host+" is something not a valid environment, please select 'local' or 'bs' ");
            System.exit(1);
        }
    }


    public static void setImplicitWait(long seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void closeApp(){
        driver.closeApp();
    }

    public static void launchApp(){
        driver.launchApp();
    }

    public static void runAppInBackGround(Duration duration){
        driver.runAppInBackground(duration);
    }

    public static void lockTheDevice(Duration duration){
        driver.lockDevice(duration);
    }

    public static void sleep(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println("Thread.sleep Exception");
        }
    }

    public static void quitBaseDriver(){
        driver.quit();
        if(host.equalsIgnoreCase(HOST_LOCAL)){
            stopService();
        }
    }


    public static String getAppName(){
        return System.getProperty(BuildParameterKeys.KEY_APP);
    }


}
