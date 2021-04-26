package helper;

import coreUtils.*;
import io.appium.java_client.android.*;
import io.github.bonigarcia.wdm.*;
import java.net.*;
import java.util.*;
import io.appium.java_client.service.local.*;
import io.appium.java_client.service.local.flags.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.*;

public class GetDriverFromCore {


    private static final String CHROME_DRIVER = "chrome";
    private static final String FIREFOX_DRIVER = "firefox";
    private static final String USERNAME = "techautomation1";
    private static final String AUTOMATE_KEY="xT8eHXvfHfkJsCN2ZDqs";
    //    private static final String APP_RED_X = "bs://bf8b0fae016d5b5b3d1f768018427bfff48b9b4f";
    private static final String APP_RED_X = "bs://9e27b0ca32c08bf27ee5d00d7c51d209a22f70c4";
    private static final String APP_DELIVERY_AGENTS = "bs://a2a333b9c7af9f1b80dfa79dcfea79b1b566de70";
    private static final String APP_RESELLER = "bs://ec50dd89ca0142b3eacb90176a2d419a6f75ae6c";
    private static final String APP_MOKAM = "bs://458ca5fd57ba2eb7c1ff5a4dd93e13ac7b09d2a6";
    private static final String APP_STORES = "bs://59f775697e32f859255074777f727a4fd73be12a";
    private static final String KEY_DEVICE_NAME="deviceName";
    private static final String KEY_PLATFORM_NAME="platformName";
    private static final String KEY_BROWSER_NAME = "browserName";
    private static final String HOST_LOCAL = "local";
    private static final String HOST_BROWSER_STACK = "bs";
    private static final String module = System.getProperty("App");


    private static AppiumDriverLocalService appiumDriverLocalService;
    private static URL url;


    private static void setBrowserStackUrl(){
        try{
            url = new URL("https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub");
        }catch (Exception e){
            System.out.println("URL Exception : "+e);
        }
    }


    // Returns Host
    private static String getHost(){
        return CoreConstants.HOST;
    }



    // Returns Port
    private static int getPort(){
        return CoreConstants.PORT;
    }



    // Returns Protocol
    private static String getProtocol(){
        return CoreConstants.PROTOCOL;
    }



    // Returns Driver Role as Hub
    private static String getDriverAsHub(){
        return CoreConstants.WEB_DRIVER_AS_HUB;
    }



    // Builds AppiumDriverLocalService
    private static void buildAppiumService(){
        // We need capabilities, host, port and arguments to build an appium-service

        // Building appiumService without capabilities

        // 1) Setup DesiredCapabilities : Here we are setting up desiredCapabilities in getDriver method

        // 2) Create AppiumServiceBuilder Object with cap, host, port and arguments
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.withIPAddress(getHost())
                .usingPort(getPort())
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        System.out.println("AppiumLocalService is Built");
    }



    // Check if AppiumServer is Already Running on that port
    private static boolean checkIfServerIsRunning(){
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(getPort());
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
            // If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }



    // Start AppiumDriverLocalService
    public static void startService(){
        buildAppiumService();
        if(!checkIfServerIsRunning()){
            appiumDriverLocalService.start();
            System.out.println("AppiumLocalService is Started : New");
        }else {
            System.out.println("AppiumLocalService is AlreadyStarted");
        }
    }



    // Stop AppiumDriverLocalService
    public static void stopService(){
        appiumDriverLocalService.stop();
        System.out.println("AppiumLocalService is Stopped");
    }



    public static WebDriver getWebDriver(String os,String os_version,String browser,String browser_version,String host) throws Exception{
        if(host.equalsIgnoreCase(HOST_LOCAL)){
             System.out.println("Control came to getWebDriver for Host : local");
            String dir = System.getProperty("user.dir");
            String filePath = dir + "/Downloads";
            System.out.println(filePath);
//             System.setProperty("webdriver.chrome.driver",CoreFileUtils.chromeDriver);
//            System.setProperty("webdriver.chrome.verboseLogging", "true");
            WebDriverManager.chromedriver().setup();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-plugins", "--disable-extensions",
                    "--disable-popup-blocking","--disable-notifications");
            if(module.equals(CoreConstants.APP_WMS)||module.equals(CoreConstants.APP_RED_X)) {
                chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.addArguments("'--disable-web-security");
            chromeOptions.addArguments("--no-sandbox");
//            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--window-size=1920,1080");
//            chromeOptions.addArguments("--user-data-dir");
            Map<String,Object> prefs = new HashMap<>();
            prefs.put("download.default_directory",filePath);
            chromeOptions.setExperimentalOption("prefs",prefs);
            }

            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
            WebDriver driver = new ChromeDriver(desiredCapabilities);
            System.out.println("Returned Driver");
            return driver;
        }else {
            setBrowserStackUrl();
            System.out.println("Control came to getWebDriver for Host : browserStack");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(BrowserStackCapabilities.KEY_OS, os);
            caps.setCapability(BrowserStackCapabilities.KEY_OS_VERSION, os_version);
            caps.setCapability(BrowserStackCapabilities.KEY_BROWSER, browser);
            caps.setCapability(BrowserStackCapabilities.KEY_BROWSER_VERSION,browser_version);
            caps.setCapability("browserstack.timezone", "Kolkata");
            caps.setCapability("resolution", "2048x1536");
            if(System.getProperty(BuildParameterKeys.KEY_APP)
                    .equalsIgnoreCase(CoreConstants.APP_WMS)){
                caps.setCapability(BrowserStackCapabilities.KEY_PROJECT, "WMS-UI");
                caps.setCapability(BrowserStackCapabilities.KEY_BUILD, "WMSWebApplicationBuild");
            }else if(System.getProperty(BuildParameterKeys.KEY_APP)
                    .equalsIgnoreCase(CoreConstants.APP_RESELLER)){
                caps.setCapability(BrowserStackCapabilities.KEY_PROJECT, "Reseller-UI");
                caps.setCapability(BrowserStackCapabilities.KEY_BUILD, "ResellerWebApplicationBuild");
            }else if(System.getProperty(BuildParameterKeys.KEY_APP)
                    .equalsIgnoreCase(CoreConstants.APP_MOKAM)){
                caps.setCapability(BrowserStackCapabilities.KEY_PROJECT, "Mokam-UI");
                caps.setCapability(BrowserStackCapabilities.KEY_BUILD, "MokamWebApplicationBuild");
            }else if(System.getProperty(BuildParameterKeys.KEY_APP)
                    .equalsIgnoreCase(CoreConstants.APP_RED_X)){
                caps.setCapability(BrowserStackCapabilities.KEY_PROJECT, "RedX-UI");
                caps.setCapability(BrowserStackCapabilities.KEY_BUILD, "RedXWebApplicationBuild");
            }
            caps.setCapability(BrowserStackCapabilities.KEY_NAME, "WebApplicationTest");
            caps.setCapability(BrowserStackCapabilities.KEY_BROWSER_STACK_VIDEO, CoreConstants.TRUE);
            caps.setCapability(BrowserStackCapabilities.KEY_BROWSER_STACK_NETWORK_LOGS,CoreConstants.TRUE);
            ChromeOptions chOptions = new ChromeOptions();
            chOptions.addArguments("--disable-plugins", "--disable-extensions",
                    "--disable-popup-blocking", "--disable-notifications", "--disable-web-security", "--allow-running-insecure-content" );
            caps.setCapability(ChromeOptions.CAPABILITY,chOptions);
            return new RemoteWebDriver(url,caps);
        }


    }



    public static WebDriver getFirefoxDriver() throws Exception{
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/core/src/main/resources/drivers/geckoDriver/");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(FIREFOX_DRIVER);
        FirefoxOptions opt =new FirefoxOptions();
        opt.addArguments("--disable-notifications");
        opt.merge(capabilities);
        return  new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
    }



    public static AndroidDriver<WebElement> getAndroidDriver(String device,String version,String host) throws Exception{
        if(host.equalsIgnoreCase(HOST_LOCAL)){
            System.out.println("Control came to getAndroidDriver for Host : local");
            AndroidAppCapabilities androidAppCapabilities = new AndroidAppCapabilities();
            return  new AndroidDriver<WebElement>(new URL(getProtocol() + getHost() + ":" + getPort() + getDriverAsHub()),
                    androidAppCapabilities.setCapabilities());
        }else{
            String app = System.getProperty(BuildParameterKeys.KEY_APP);
            setBrowserStackUrl();
            System.out.println("Control came to getAndroidDriver for Host : browserStack");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(BrowserStackCapabilities.KEY_ANDROID_DEVICE, device);
            caps.setCapability(BrowserStackCapabilities.KEY_ANDROID_VERSION, version);
            if(app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
                caps.setCapability(BrowserStackCapabilities.KEY_PROJECT, "Reseller-Android-UI");
                caps.setCapability(BrowserStackCapabilities.KEY_BUILD, "ResellerAndroidBuild");
                caps.setCapability(BrowserStackCapabilities.KEY_APP, APP_RESELLER);
            } else if(app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
                caps.setCapability(BrowserStackCapabilities.KEY_PROJECT, "Mokam-Android-UI");
                caps.setCapability(BrowserStackCapabilities.KEY_BUILD, "MokamAndroidBuild");
                caps.setCapability(BrowserStackCapabilities.KEY_APP, APP_MOKAM);
            }else if(app.equalsIgnoreCase(CoreConstants.APP_RED_X)){
                caps.setCapability(BrowserStackCapabilities.KEY_PROJECT, "RedX-Android-UI");
                caps.setCapability(BrowserStackCapabilities.KEY_BUILD, "RedXAndroidBuild");
                caps.setCapability(BrowserStackCapabilities.KEY_APP, APP_RED_X);
            }else if(app.equalsIgnoreCase(CoreConstants.APP_STORES)){
                caps.setCapability(BrowserStackCapabilities.KEY_PROJECT, "Stores-Android-UI");
                caps.setCapability(BrowserStackCapabilities.KEY_BUILD, "StoresAndroidBuild");
                caps.setCapability(BrowserStackCapabilities.KEY_APP, APP_STORES);
            } if(app.equalsIgnoreCase(CoreConstants.APP_DELIVERY_AGENTS)) {
                caps.setCapability(BrowserStackCapabilities.KEY_PROJECT, "Delivery-Agents-Android-UI");
                caps.setCapability(BrowserStackCapabilities.KEY_BUILD, "DeliveryAgentsAndroidBuild");
                caps.setCapability(BrowserStackCapabilities.KEY_APP,APP_DELIVERY_AGENTS);
            }
            caps.setCapability(BrowserStackCapabilities.KEY_NAME, "AndroidAppTest");
//            if(System.getProperty(BuildParameterKeys.KEY_APP).equalsIgnoreCase(CoreConstants.APP_MOKAM)){
//                caps.setCapability(BrowserStackCapabilities.KEY_APP, APP_MOKAM);
//            }else if(System.getProperty(BuildParameterKeys.KEY_APP).equalsIgnoreCase(CoreConstants.APP_RESELLER)){
//                caps.setCapability(BrowserStackCapabilities.KEY_APP, APP_RESELLER);
//            }
            caps.setCapability(BrowserStackCapabilities.KEY_BROWSER_STACK_VIDEO, CoreConstants.TRUE);
            //caps.setCapability(BrowserStackCapabilities.KEY_BROWSER_STACK_NETWORK_LOGS,CoreConstants.TRUE);
            System.out.println("URL is :"+url);
            return new AndroidDriver<WebElement>(url,caps);

        }
    }



    public static AndroidDriver<WebElement> getAndroidDriverForChrome(String device,String version,String host,String browser,String browserVersion) throws Exception{
        if(host.equalsIgnoreCase(HOST_LOCAL)) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(KEY_PLATFORM_NAME, "Android");
            capabilities.setCapability(KEY_DEVICE_NAME, "TestingDevice");
            capabilities.setCapability(KEY_BROWSER_NAME, "Chrome");
            capabilities.setCapability("chromedriverUseSystemExecutable", CoreConstants.FALSE);
            System.out.println("ChromeDriverPath is : " + CoreFileUtils.chromeDriver);
            capabilities.setCapability("chromedriverExecutable", CoreFileUtils.chromeDriver);
            ChromeOptions chOptions = new ChromeOptions();
            chOptions.addArguments("--disable-plugins", "--disable-extensions",
                    "--disable-popup-blocking","--disable-notifications");
            capabilities.setCapability(ChromeOptions.CAPABILITY,chOptions);
            URL url = new URL(getProtocol() + getHost() + ":" + getPort() + getDriverAsHub());
            return new AndroidDriver<WebElement>(url, capabilities);
        }
        else {
            setBrowserStackUrl();
            System.out.println("Control came to BrowserStackDriver");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(BrowserStackCapabilities.KEY_ANDROID_DEVICE, device);
            caps.setCapability(BrowserStackCapabilities.KEY_ANDROID_VERSION, version);
            if(System.getProperty(BuildParameterKeys.KEY_APP)
                    .equalsIgnoreCase(CoreConstants.APP_RESELLER)){
                caps.setCapability(BrowserStackCapabilities.KEY_PROJECT, "Reseller-WAP-UI");
                caps.setCapability(BrowserStackCapabilities.KEY_BUILD, "ResellerWAPBuild");
            } else if(System.getProperty(BuildParameterKeys.KEY_APP)
                    .equalsIgnoreCase(CoreConstants.APP_MOKAM)){
                caps.setCapability(BrowserStackCapabilities.KEY_PROJECT, "Mokam-WAP-UI");
                caps.setCapability(BrowserStackCapabilities.KEY_BUILD, "MokamWAPBuild");
            }else if(System.getProperty(BuildParameterKeys.KEY_APP)
                    .equalsIgnoreCase(CoreConstants.APP_STORE)){
                caps.setCapability(BrowserStackCapabilities.KEY_PROJECT, "Store-WAP-UI");
                caps.setCapability(BrowserStackCapabilities.KEY_BUILD, "StoreWAPBuild");
            }
            caps.setCapability(BrowserStackCapabilities.KEY_NAME, "WAPTest");
            caps.setCapability(BrowserStackCapabilities.KEY_BROWSER,browser);
            caps.setCapability(BrowserStackCapabilities.KEY_BROWSER_VERSION,browserVersion);
            caps.setCapability(BrowserStackCapabilities.KEY_BROWSER_STACK_VIDEO, CoreConstants.TRUE);
            caps.setCapability(BrowserStackCapabilities.KEY_BROWSER_STACK_NETWORK_LOGS,CoreConstants.TRUE);
            ChromeOptions chOptions = new ChromeOptions();
            chOptions.addArguments("--disable-plugins", "--disable-extensions",
                    "--disable-popup-blocking","--disable-notifications");
            caps.setCapability(ChromeOptions.CAPABILITY,chOptions);
            return new AndroidDriver<WebElement>(url, caps);
        }
    }



}
