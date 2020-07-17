package utils;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import coreUtils.DomainPropertyReader;
import helper.GetDriverFromCore;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class WmsBaseClass extends GetDriverFromCore{

    private static String HOST_LOCAL = "local";
    private static String HOST_BROWSER_STACK = "bs";
    private static String OS = "Os";
    private static String OS_VERSION = "OSv";
    private static String BROWSER = "Br";
    private static String BROWSER_VERSION = "BRv";
    private static WebDriver driver=null;
    private static String host = System.getProperty("Host");



    public static WebDriver getBaseDriver() throws Exception{
            if(driver==null){
                setUpDriver();
            }
            return  driver;
    }



    private static void setUpDriver()throws Exception{
        if (host.equalsIgnoreCase(HOST_LOCAL)) {
            driver = GetDriverFromCore.
                    getWebDriver(null,null,null,null,host);
        }else if(host.equalsIgnoreCase(HOST_BROWSER_STACK)){
            // Write a function to retrieve devices and their versions
            String os = System.getProperty(OS);
            String os_version = System.getProperty(OS_VERSION);
            String browser = System.getProperty(BROWSER);
            String browser_version = System.getProperty(BROWSER_VERSION);
            driver = GetDriverFromCore.getWebDriver(os,os_version,browser,browser_version,host);
        }else {
            System.out.println(host+" is something not a valid environment, please select 'local' or 'bs' ");
            System.exit(1);
        }
    }


    public static String getWmsBaseUrl() throws Exception{
        String env = System.getProperty(BuildParameterKeys.KEY_ENV);
        switch (env){
            case CoreConstants.ENV_STAGE :
                return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.WMS_WEB_STAGE_BASE_URL);
            case CoreConstants.ENV_PROD :
                return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.WMS_WEB_PROD_BASE_URL);
        }
        System.out.println("Returning Default URL : Stage");
        return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.WMS_WEB_STAGE_BASE_URL);
    }




    public static void setImplicitWait(long seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }



    public static void browserMaximize(){
        driver.manage().window().maximize();
    }



    public static void browserFullScreen(){
        driver.manage().window().fullscreen();
    }



    public static void closeBrowser(){
        driver.close();
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
    }


}
