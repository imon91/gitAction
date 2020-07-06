package coreUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidAppCapabilities {


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
    private static final String CAP_ANDROID_INSTALL_TIME_OUT = "androidInstallTimeout";
    private static final String CAP_KEY_IS_HEADLESS="isHeadless";
    private static final String CAP_KEY_ADV_ARGS="-no-window";
    private static final String CAP_KEY_APPIUM_CHROME_OPTIONS = "appium:chromeOptions";
    private static final String CAP_KEY_W3C = "w3c";



    public DesiredCapabilities setCapabilities(){
        String env = System.getProperty(BuildParameterKeys.KEY_ENV);
        String app = System.getProperty(BuildParameterKeys.KEY_APP);
        DesiredCapabilities cap= new DesiredCapabilities();
        cap.setCapability(CAP_KEY_DEVICE_NAME, CoreConstants.ANDROID_DEVICE_NAME);
        cap.setCapability(CAP_KEY_PLATFORM_NAME, CoreConstants.PLATFORM_ANDROID);
        //cap.setCapability(CAP_KEY_PLATFORM_VERSION, Constants.ANDROID_PLATFORM_VERSION);

        if(env.equalsIgnoreCase(CoreConstants.ENV_STAGE) &&
                app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            cap.setCapability(CAP_KEY_APP, CoreFileUtils.resellerStageApk);
            cap.setCapability(CAP_KEY_APP_PACKAGE, CoreConstants.RESELLER_APP_PACKAGE);
        }else if(env.equalsIgnoreCase(CoreConstants.ENV_PROD) &&
                app.equalsIgnoreCase(CoreConstants.APP_RESELLER)){
            cap.setCapability(CAP_KEY_APP, CoreFileUtils.resellerProdApk);
            cap.setCapability(CAP_KEY_APP_PACKAGE, CoreConstants.RESELLER_APP_PACKAGE);
        }else if(env.equalsIgnoreCase(CoreConstants.ENV_STAGE) &&
                app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            cap.setCapability(CAP_KEY_APP, CoreFileUtils.mokamStageApk);
            cap.setCapability(CAP_KEY_APP_PACKAGE, CoreConstants.MOKAM_APP_PACKAGE);
        }else if(env.equalsIgnoreCase(CoreConstants.ENV_PROD) &&
                app.equalsIgnoreCase(CoreConstants.APP_MOKAM)){
            cap.setCapability(CAP_KEY_APP, CoreFileUtils.mokamProdApk);
            cap.setCapability(CAP_KEY_APP_PACKAGE, CoreConstants.MOKAM_APP_PACKAGE);
        }

        cap.setCapability(CAP_KEY_AUTOMATION_NAME, CoreConstants.ANDROID_AUTOMATION_NAME);
        cap.setCapability(CAP_KEY_APP_ACTIVITY, CoreConstants. ANDROID_MAIN_ACTIVITY);
        cap.setCapability(CAP_KEY_LOCATION_SERVICES_AUTHORIZED, CoreConstants.TRUE);
        cap.setCapability(CAP_KEY_AUTO_ACCEPT_ALERTS, CoreConstants.TRUE);
        cap.setCapability(CAP_KEY_ADB_EXEC_TIME_OUT, CoreConstants.ABD_EXEC_TIME_OUT);
        cap.setCapability(CAP_KEY_ENSURE_WEB_VIEWS_HAVE_PAGES, CoreConstants.TRUE);
        cap.setCapability(CAP_KEY_CHROME_DRIVER_USE_SYSTEM_EXECUTABLE, CoreConstants.FALSE);
        cap.setCapability(CAP_UIAUTOMATOR2_SERVER_INSTALL_TIMEOUT,20000);
        cap.setCapability(CAP_ANDROID_INSTALL_TIME_OUT,900000);
        cap.setCapability(CAP_KEY_APPIUM_CHROME_OPTIONS, ImmutableMap.of(CAP_KEY_W3C, CoreConstants.FALSE));
        //cap.setCapability(CAP_KEY_CHROME_DRIVER_MAPPING_FILE,"/Users/vogo-1161/AutomationTests/Shopf-Ui-Automation/src/main/resources/chromeDrivers/chromedrivers.json");
        cap.setCapability(CAP_KEY_CHROME_DRIVER_EXECUTABLE_DIR, CoreFileUtils.chromeDriversFolderPath);
        cap.setCapability(CAP_KEY_CHROME_DRIVER_EXECUTABLE, CoreFileUtils.chromeDriver);
        cap.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS,true);
        cap.setCapability("nativeWebScreenshot",true);
        cap.setCapability("androidScreenshotPath","target/screenshots");
        //cap.setCapability(CAP_KEY_IS_HEADLESS,true);
        //cap.setCapability(CAP_KEY_ADV_ARGS, "-no-window");

        return cap;

    }

}
