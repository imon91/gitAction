package helper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import coreUtils.AndroidAppCapabilities;
import coreUtils.CoreConstants;
import coreUtils.CoreFileUtils;

import java.net.ServerSocket;
import java.net.URL;

public class GetDriverFromCore {

    private static final String CHROME_DRIVER = "chrome";
    private static final String FIREFOX_DRIVER = "firefox";
    private static final String ANDROID_DRIVER = "android";
    private static final String ANDROID_CHROME_DRIVER = "androidChrome";

    private FirefoxDriver firefoxDriver;
    private ChromeDriver chromeDriver;
    private AndroidDriver<AndroidElement> androidDriver;

    private String driver = null;

    public GetDriverFromCore(){

    }

    private AppiumDriverLocalService appiumDriverLocalService;

    // Returns Host
    private String getHost(){
        return CoreConstants.HOST;
    }

    // Returns Port
    private int getPort(){
        return CoreConstants.PORT;
    }

    // Returns Protocol
    private String getProtocol(){
        return CoreConstants.PROTOCOL;
    }

    // Returns Driver Role as Hub
    private String getDriverAsHub(){
        return CoreConstants.WEB_DRIVER_AS_HUB;
    }


    // Builds AppiumDriverLocalService
    private void buildAppiumService(){
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
    private boolean checkIfServerIsRunning(){
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
    public void startService(){
        buildAppiumService();
        if(!checkIfServerIsRunning()){
            appiumDriverLocalService.start();
            System.out.println("AppiumLocalService is Started : New");
        }else {
            System.out.println("AppiumLocalService is AlreadyStarted");
        }
    }

    // Stop AppiumDriverLocalService
    public void stopService(){
        appiumDriverLocalService.stop();
        System.out.println("AppiumLocalService is Stopped");
    }





    public WebDriver getChromeDriver(String os,String os_version,String browser,String browser_version) throws Exception{
        String host = System.getProperty("Host");
        System.out.println("Host is : "+host);
        if(host.equalsIgnoreCase("local")){
            System.setProperty("webdriver.chrome.driver",CoreFileUtils.chromeDriver);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(CHROME_DRIVER);
            ChromeOptions opt =new ChromeOptions();
            opt.addArguments("--disable-notifications");
            opt.merge(capabilities);
            return new ChromeDriver(capabilities);
        }else {
            String USERNAME = "jagadeeshb4";
            String AUTOMATE_KEY = "fCxvFMgRR1xx9YxX5TcQ";
            String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os", os);
            caps.setCapability("os_version", os_version);
            caps.setCapability("browser", browser);
            caps.setCapability("browser_version",browser_version);
            ChromeOptions opt =new ChromeOptions();
            opt.addArguments("--disable-notifications");
            caps.setCapability(ChromeOptions.CAPABILITY,opt);
            return new RemoteWebDriver(new URL(URL),caps);
        }

    }

    public WebDriver getFirefoxDriver() throws Exception{
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/core/src/main/resources/drivers/geckoDriver/");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(FIREFOX_DRIVER);
        FirefoxOptions opt =new FirefoxOptions();
        opt.addArguments("--disable-notifications");
        opt.merge(capabilities);
        return  new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
    }

    public AndroidDriver<AndroidElement> getAndroidDriver(String device,String version) throws Exception{
        String host = System.getProperty("Host");
        System.out.println("Host is : "+host);
        if(host.equalsIgnoreCase("local")){
            AndroidAppCapabilities androidAppCapabilities = new AndroidAppCapabilities();
            return  new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),
                    androidAppCapabilities.setCapabilities());
        }else{
            String userName = "jagadeeshb4";
            String accessKey = "fCxvFMgRR1xx9YxX5TcQ";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("device", device);
            caps.setCapability("os_version", version);
            caps.setCapability("project", "AndroidAppAutomation");
            caps.setCapability("build", "ResellerAutomationBuild");
            caps.setCapability("name", "AndroidAppTest");
            caps.setCapability("app", "bs://c51201e9e1baeb46e7d44a18541d6558caac9df1");
            caps.setCapability("browserstack.video", "true");
            return new AndroidDriver<AndroidElement>(
                    new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

        }
    }

    public AndroidDriver<WebElement> getAndroidDriverForChrome(String device,String version) throws Exception{
        String host = System.getProperty("Host");
        if(host.equalsIgnoreCase("local") || host==null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "TestingDevice");
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("chromedriverUseSystemExecutable", CoreConstants.FALSE);
            System.out.println("ChromeDriverPath is : " + CoreFileUtils.chromeDriver);
            capabilities.setCapability("chromedriverExecutable", CoreFileUtils.chromeDriver);
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--disable-notifications");
            opt.merge(capabilities);
            URL url = new URL(getProtocol() + getHost() + ":" + getPort() + getDriverAsHub());
            return new AndroidDriver<WebElement>(url, capabilities);
        }
        else {
            System.out.println("Control came to BrowserStackDriver");
            String userName = "jagadeeshb4";
            String accessKey = "fCxvFMgRR1xx9YxX5TcQ";
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("device", device);
            caps.setCapability("os_version", version);
            caps.setCapability("project", "AndroidAppAutomation2");
            caps.setCapability("build", "ResellerAutomationBuild2");
            caps.setCapability("name", "AndroidWebAppTest2");
            caps.setCapability("browser",MobileBrowserType.CHROME);
            caps.setCapability("browser_version","83.0");
            caps.setCapability("browserstack.video", "true");
            return new AndroidDriver<WebElement>
                    (new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

        }
    }

}
