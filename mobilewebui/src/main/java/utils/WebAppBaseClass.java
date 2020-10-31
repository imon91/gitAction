package utils;


import coreUtils.*;
import helper.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;

public class WebAppBaseClass extends GetDriverFromCore{

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
            return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.RESELLER_WAP_STAGE_BASE_URL);
        } else if (app.equalsIgnoreCase(CoreConstants.APP_RESELLER)
                && env.equalsIgnoreCase(CoreConstants.ENV_PROD)) {
            return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.RESELLER_WAP_PROD_BASE_URL);
        } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)
                && env.equalsIgnoreCase(CoreConstants.ENV_STAGE)) {
            return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.MOKAM_WAP_STAGE_BASE_URL);
        } else if (app.equalsIgnoreCase(CoreConstants.APP_MOKAM)
                && env.equalsIgnoreCase(CoreConstants.ENV_PROD)) {
            return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.MOKAM_WAP_PROD_BASE_URL);
        } else {
            System.out.println("Returning default RESELLER_WAP_STAGE_BASE_URL");
            return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.RESELLER_WAP_STAGE_BASE_URL);
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

    public static List<WebElement> xpathListSetter(String xpath){
        List<WebElement> elementList;
        try {
            elementList = getBaseDriver().findElements(By.xpath(xpath));
            return elementList;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static WebElement xpathSetter(String xpath){
        try {
            new WebDriverWait(getBaseDriver(),30)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return getBaseDriver().findElement(By.xpath(xpath));
        }catch (Exception e){
            System.out.println(e);
            if(e.getMessage().contains("NoSuchElementException")){
                int loop=0;
                while(loop<3){
                    sleep(2000);
                    xpathListSetter(xpath);
                    loop++;
                }
            }

        }
        return null;
    }

    public static String getAppName(){
        return System.getProperty(BuildParameterKeys.KEY_APP);
    }


}

