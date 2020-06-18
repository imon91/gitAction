package utils;


import coreUtils.CoreConstants;
import helper.GetDriverFromCore;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebAppBaseClass extends GetDriverFromCore{

    private static String HOST_LOCAL = "local";
    private static String HOST_BROWSER_STACK = "bs";
    private static String ENV_RESELLER = "Reseller";
    private static String ENV_UNICORN = "Unicorn";
    private static AndroidDriver<WebElement> driver = null;
    private static String host = System.getProperty("Host");



    public static AndroidDriver<WebElement> getBaseDriver() throws Exception{
        if(driver==null){
            setUpDriver();
        }
        return  driver;
    }


    public static String getWAPBaseUrl(){
        String environment = System.getProperty("Env");
        if(environment.equalsIgnoreCase(ENV_RESELLER)){
            return CoreConstants.RESELLER_STAGE_BASE_URL;
        }else if(environment.equalsIgnoreCase(ENV_UNICORN)){
            return CoreConstants.UNICORN_STAGE_BASE_URL;
        }else {
            return ENV_RESELLER;
        }
    }


    private static void setUpDriver()throws Exception{
        if (host.equalsIgnoreCase(HOST_LOCAL)) {
            startService();
            driver = GetDriverFromCore.getAndroidDriverForChrome(null,null,host);
        }else if(host.equalsIgnoreCase(HOST_BROWSER_STACK)){
            String device = System.getProperty("Device");
            String version = System.getProperty("Version");
            driver = GetDriverFromCore.getAndroidDriverForChrome(device,version,host);
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


}

