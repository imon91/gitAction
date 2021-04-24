package utils;

import coreUtils.CoreConstants;
import helper.GetDriverFromCore;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class DeliveryAgentsBaseClass extends GetDriverFromCore{


    private static String HOST_LOCAL = "local";
    private static String HOST_BROWSER_STACK = "bs";
    private static AndroidDriver<WebElement> driver = null;
    private static String host = System.getProperty("Host");


    public static AndroidDriver<WebElement> getBaseDriver(){
        try {
            if(driver==null){
                setUpDriver();
            }
            return  driver;
        }catch (Exception e){
            System.out.println(e);
        }
        return driver;
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

    public void launchApp(){
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


//    public static String getAppPackage(){
//        System.out.println("Get AppPackage is Called");
//        String packageName = null;
//        if(System.getProperty(BuildParameterKeys.KEY_APP).
//                equalsIgnoreCase(CoreConstants.APP_RESELLER)){
//            packageName =  CoreConstants.RESELLER_APP_PACKAGE;
//        }else if(System.getProperty(BuildParameterKeys.KEY_APP).
//                equalsIgnoreCase(CoreConstants.APP_MOKAM)){
//            packageName =  CoreConstants.MOKAM_APP_PACKAGE;
//        }else {
//            //Default
//            packageName =  CoreConstants.RESELLER_APP_PACKAGE;
//        }
//        System.out.println("PackageName Returned is : "+packageName);
//        return packageName;
//    }



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
        System.out.println("Context Switched From Web To Native");
    }



    public static void quitBaseDriver(){
        driver.quit();
        System.out.println("Driver is Quit");
        if(host.equalsIgnoreCase(HOST_LOCAL)){
            stopService();
        }
    }


    public static WebElement xpathSetter(String xpath){
        try {
            new WebDriverWait(getBaseDriver(),10)
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
        try {
            new WebDriverWait(getBaseDriver(),10)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return getBaseDriver().findElements(By.xpath(xpath));
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    public static WebElement idSetter(String id){
        try {
            return getBaseDriver().findElementById(id);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    public static List<WebElement> idListSetter(String id){
        List<WebElement> elementList;
        try {
            elementList = getBaseDriver().findElements(By.id(id));
            return elementList;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    public static List<WebElement> classListSetter(String className){
        List<WebElement> elementList;
        try {
            elementList = getBaseDriver().findElements(By.className(className));
            return elementList;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static WebElement classSetter(String className){
        try {
            return getBaseDriver().findElementById(className);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static WebElement uiAutomatorSetter(String selector){
        try{
            return getBaseDriver().findElementByAndroidUIAutomator(selector);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static WebElement childXpathSetter(List<WebElement> elements,int index,String xpath){
        try {
            new WebDriverWait(getBaseDriver(),10)
                    .until(ExpectedConditions.visibilityOf(elements.get(index).findElement(By.xpath(xpath))));
            return elements.get(index).findElement(By.xpath(xpath));
        }catch (Exception e){
            System.out.println(e);
            if(e.getMessage().contains("NoSuchElementException")){
                int loop=0;
                while(loop<3){
                    sleep(2000);
                    childXpathSetter(elements,index,xpath);
                    loop++;
                }
            }

        }
        return null;
    }

    public static void refreshPage() {
        Dimension screenSize = getBaseDriver().manage().window().getSize();
        new TouchAction(getBaseDriver())
                .press(PointOption.point(screenSize.getWidth()/2,screenSize.getHeight()/4))
                .moveTo(PointOption.point(screenSize.getWidth()/2,3*screenSize.getHeight()/4))
                .perform().release();
    }




}

