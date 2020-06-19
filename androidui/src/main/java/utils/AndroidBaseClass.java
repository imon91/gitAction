package utils;

import coreUtils.BuildParameterKeys;
import coreUtils.CoreConstants;
import helper.GetDriverFromCore;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class AndroidBaseClass extends GetDriverFromCore{



    private static String HOST_LOCAL = "local";
    private static String HOST_BROWSER_STACK = "bs";
    private static AndroidDriver<AndroidElement> driver = null;
    private static String host = System.getProperty("Host");




    public static AndroidDriver<AndroidElement> getBaseDriver() throws Exception{
        if(driver==null){
            setUpDriver();
        }
        return  driver;
    }



    private static void setUpDriver()throws Exception{
            if (host.equalsIgnoreCase(HOST_LOCAL)) {
                startService();
                driver = GetDriverFromCore.getAndroidDriver(null,null,host);
            }else if(host.equalsIgnoreCase(HOST_BROWSER_STACK)){
                String device = System.getProperty("Device");
                String version = System.getProperty("Version");
                driver = GetDriverFromCore.getAndroidDriver(device,version,host);
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


    public static String getAppPackage(){
        System.out.println("Get AppPackage is Called");
        String packageName = null;
        if(System.getProperty(BuildParameterKeys.KEY_APP).
                equalsIgnoreCase(CoreConstants.APP_RESELLER)){
           packageName =  CoreConstants.RESELLER_APP_PACKAGE;
        }else if(System.getProperty(BuildParameterKeys.KEY_APP).
                equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            packageName =  CoreConstants.MOKAM_APP_PACKAGE;
        }else {
            //Default
            packageName =  CoreConstants.RESELLER_APP_PACKAGE;
        }
        System.out.println("PackageName Returned is : "+packageName);
        return packageName;
    }

    public static Boolean switchFromNativeToWeb(String webContext){
        sleep(2000);
        // Context Switching
        Set<String> contextNames = driver.getContextHandles();
        int n = contextNames.size();
        String contextData[] = new String[n];
        contextData = contextNames.toArray(contextData);
        for(int i=0;i<contextData.length;i++){
            System.out.println(contextData[i]);
        }
        if(contextNames.contains(webContext)){
            driver.context(webContext);
            return true;
        }else {
            System.out.println("Not Context available : "+webContext);
            return false;
        }
    }

    public static void switchFromWebToNative(){
        driver.context(CoreConstants.SHOP_UP_NATIVE_VIEW);
    }



    public static void quitBaseDriver(){
        driver.quit();
        System.out.println("Driver is Quit");
        if(host.equalsIgnoreCase(HOST_LOCAL)){
            stopService();
        }
    }



}

