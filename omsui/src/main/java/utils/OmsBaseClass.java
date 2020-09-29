package utils;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import coreUtils.DomainPropertyReader;
import helper.GetDriverFromCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OmsBaseClass extends GetDriverFromCore{

        private static final String HOST_LOCAL = "local";
        private static final String HOST_BROWSER_STACK = "bs";
        private static final String OS = "Os";
        private static final String OS_VERSION = "OSv";
        private static final String BROWSER = "Br";
        private static final String BROWSER_VERSION = "BRv";
        private static WebDriver driver=null;
        private static final String host = System.getProperty("Host");



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


        public static String getOmsBaseUrl() throws Exception{
            String env = System.getProperty(BuildParameterKeys.KEY_ENV);
            switch (env){
                case CoreConstants.ENV_STAGE :
                    return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.OMS_WEB_STAGE_BASE_URL);
                case CoreConstants.ENV_PROD :
                    return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.WMS_WEB_PROD_BASE_URL);
            }
            System.out.println("Returning Default URL : Stage");
            return DomainPropertyReader.getValueOfKey(DomainPropertyReader.Keys.OMS_WEB_STAGE_BASE_URL);
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

        public static WebElement xpathSetter(String xpath){
            try {
                new WebDriverWait(getBaseDriver(),5)
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                return getBaseDriver().findElement(By.xpath(xpath));
            }catch (Exception e){
                System.out.println(e);
                if(e.getMessage().contains("NoSuchElementException")){
                    int loop=0;
                    while(loop<3){
                        xpathSetter(xpath);
                        loop++;
                    }
                }

            }
            return null;
        }

        public static WebElement xpathSetterPresence(String xpath){
            try {
                new WebDriverWait(getBaseDriver(),5)
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                return getBaseDriver().findElement(By.xpath(xpath));
            }catch (Exception e){
                System.out.println(e);
                if(e.getMessage().contains("NoSuchElementException")){
                    int loop=0;
                    while(loop<3){
                        xpathSetterPresence(xpath);
                        loop++;
                    }
                }

            }
            return null;
        }

        public static WebElement xpathSetterClick(String xpath){
            try {
                new WebDriverWait(getBaseDriver(),5)
                        .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                return getBaseDriver().findElement(By.xpath(xpath));
            }catch (Exception e){
                System.out.println(e);
                if(e.getMessage().contains("NoSuchElementException")){
                    int loop=0;
                    while(loop<3){
                        xpathSetterClick(xpath);
                        loop++;
                    }
                }

            }
            return null;
        }

        public static void quitBaseDriver(){
            driver.quit();
        }


    }
