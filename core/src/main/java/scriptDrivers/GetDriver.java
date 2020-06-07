package scriptDrivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetDriver {

    private static final String CHROME_DRIVER = "chrome";
    private static final String FIREFOX_DRIVER = "firefox";
    private static final String ANDROID_DRIVER = "android";

    private FirefoxDriver firefoxDriver;
    private ChromeDriver chromeDriver;
    private AndroidDriver<AndroidElement> androidDriver;

    private String driver = null;

    public GetDriver(String driver){
        this.driver = driver;
    }

}
