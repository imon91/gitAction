package utils;

import coreUtils.*;
import helper.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.*;
import java.util.concurrent.*;


public class RedXWebBaseClass extends GetDriverFromCore {

    private static final String HOST_LOCAL = "local";
    private static final String HOST_BROWSER_STACK = "bs";
    private static final String OS = "Os";
    private static final String OS_VERSION = "OSv";
    private static final String BROWSER = "Br";
    private static final String BROWSER_VERSION = "BRv";
    private static WebDriver driver = null;
    private static final String host = System.getProperty("Host");


    public static WebDriver getBaseDriver() throws Exception {
        if (driver == null) {
            setUpDriver();
        }
        return driver;
    }


    private static void setUpDriver() throws Exception {
        if (host.equalsIgnoreCase(HOST_LOCAL)) {
            driver = GetDriverFromCore.
                    getWebDriver(null, null, null, null, host);
        } else if (host.equalsIgnoreCase(HOST_BROWSER_STACK)) {
            // Write a function to retrieve devices and their versions
            String os = System.getProperty(OS);
            String os_version = System.getProperty(OS_VERSION);
            String browser = System.getProperty(BROWSER);
            String browser_version = System.getProperty(BROWSER_VERSION);
            driver = GetDriverFromCore.getWebDriver(os, os_version, browser, browser_version, host);
        } else {
            System.out.println(host + " is something not a valid environment, please select 'local' or 'bs' ");
            System.exit(1);
        }
    }



    public static String getWebBaseUrl() throws Exception{
        String env = System.getProperty(BuildParameterKeys.KEY_ENV);
        String app = System.getProperty(BuildParameterKeys.KEY_APP);
        if(app.equalsIgnoreCase(CoreConstants.APP_RED_X)
                && env.equalsIgnoreCase(CoreConstants.ENV_STAGE)){
            return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.REDX_WEB_STAGE_BASE_URL);
        }else if(app.equalsIgnoreCase(CoreConstants.APP_RED_X)
                && env.equalsIgnoreCase(CoreConstants.ENV_PROD)){
            return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.REDX_WEB_PROD_BASE_URL);
        }else {
            System.out.println("Returning default REDX_WEB_STAGE_BASE_URL");
            return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.REDX_WEB_STAGE_BASE_URL);
        }
    }


    public static void setImplicitWait(long seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }


    public static void browserMaximize() {
        driver.manage().window().maximize();
    }


    public static void browserFullScreen() {
        driver.manage().window().fullscreen();
    }


    public static void closeBrowser() {
        driver.close();
    }


    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            System.out.println("Thread.sleep Exception");
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

    public static WebElement xpathPresenceSetter(String xpath){
        try {
            new WebDriverWait(getBaseDriver(),2)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return getBaseDriver().findElement(By.xpath(xpath));
        }catch (Exception e){
            System.out.println(e);
            if(e.getMessage().contains("NoSuchElementException")){
                int loop=0;
                while(loop<3){
                    sleep(500);
                    xpathListSetter(xpath);
                    loop++;
                }
            }

        }
        return null;
    }


    public static void quitBaseDriver() {
        driver.quit();
    }


}
