package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ResellerAndroidCapabilities {
    private static final String CAP_KEY_DEVICE_NAME="deviceName";
    private static final String CAP_KEY_PLATFORM_NAME="platformName";
    private static final String CAP_KEY_PLATFORM_VERSION="platformVersion";
    private static final String CAP_KEY_APP="app";
    private static final String CAP_KEY_APP_PACKAGE="appPackage";
    private static final String CAP_KEY_AUTOMATION_NAME="automationName";
    private static final String CAP_KEY_APP_ACTIVITY="appActivity";
    private static final String CAP_KEY_LOCATION_SERVICES_AUTHORIZED="locationServicesAuthorized";
    private static final String CAP_KEY_AUTO_ACCEPT_ALERTS="autoAcceptAlerts";
    private static final String CAP_KEY_ADB_EXEC_TIME_OUT="adbExecTimeout";
    private static final String CAP_KEY_ENSURE_WEB_VIEWS_HAVE_PAGES="ensureWebviewsHavePages";
    private static final String CAP_KEY_CHROME_DRIVER_USE_SYSTEM_EXECUTABLE="chromedriverUseSystemExecutable";
    private static final String CAP_KEY_CHROME_DRIVER_MAPPING_FILE="chromedriverChromeMappingFile";
    private static final String CAP_KEY_CHROME_DRIVER_EXECUTABLE_DIR="chromedriverExecutableDir";
    private static final String CAP_KEY_CHROME_DRIVER_EXECUTABLE="chromedriverExecutable";
    private static final String CAP_UIAUTOMATOR2_SERVER_INSTALL_TIMEOUT = "uiautomator2ServerInstallTimeout";
    private static final String CAP_KEY_IS_HEADLESS="isHeadless";
    private static final String CAP_KEY_ADV_ARGS="-no-window";
    private static final String CAP_KEY_APPIUM_CHROME_OPTIONS = "appium:chromeOptions";
    private static final String CAP_KEY_W3C = "w3c";



    public DesiredCapabilities setCapabilities(){


        DesiredCapabilities cap= new DesiredCapabilities();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        cap.setCapability(ChromeOptions.CAPABILITY, opt);
        cap.setCapability(CAP_KEY_DEVICE_NAME, Constants.ANDROID_DEVICE_NAME);
        cap.setCapability(CAP_KEY_PLATFORM_NAME, Constants.PLATFORM_ANDROID);
        //cap.setCapability(CAP_KEY_PLATFORM_VERSION, Constants.ANDROID_PLATFORM_VERSION);
        cap.setCapability(CAP_KEY_APP,FileUtils.apkFile);
        //cap.setCapability(CAP_KEY_APP_PACKAGE, Constants.APP_PACKAGE);
        cap.setCapability(CAP_KEY_AUTOMATION_NAME, Constants.ANDROID_AUTOMATION_NAME);
        //cap.setCapability(CAP_KEY_APP_ACTIVITY, Constants. ANDROID_MAIN_ACTIVITY);
        cap.setCapability(CAP_KEY_LOCATION_SERVICES_AUTHORIZED, Constants.TRUE);
        cap.setCapability(CAP_KEY_AUTO_ACCEPT_ALERTS, Constants.TRUE);
        cap.setCapability(CAP_KEY_ADB_EXEC_TIME_OUT,Constants.ABD_EXEC_TIME_OUT);
        cap.setCapability(CAP_KEY_ENSURE_WEB_VIEWS_HAVE_PAGES,Constants.TRUE);
        cap.setCapability(CAP_KEY_CHROME_DRIVER_USE_SYSTEM_EXECUTABLE,Constants.FALSE);
        cap.setCapability(CAP_UIAUTOMATOR2_SERVER_INSTALL_TIMEOUT,20000);
        cap.setCapability(CAP_KEY_APPIUM_CHROME_OPTIONS, ImmutableMap.of(CAP_KEY_W3C, Constants.FALSE));
        //cap.setCapability(CAP_KEY_CHROME_DRIVER_MAPPING_FILE,"/Users/vogo-1161/AutomationTests/Shopf-Ui-Automation/src/main/resources/chromeDrivers/chromedrivers.json");
        cap.setCapability(CAP_KEY_CHROME_DRIVER_EXECUTABLE_DIR,FileUtils.chromeDriversFolderPath);
        cap.setCapability(CAP_KEY_CHROME_DRIVER_EXECUTABLE, FileUtils.chromeDriver);
        cap.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS,true);
        //cap.setCapability(CAP_KEY_IS_HEADLESS,true);
        //cap.setCapability(CAP_KEY_ADV_ARGS, "-no-window");

        return cap;
}
}
