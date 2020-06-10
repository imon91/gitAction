package MyUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DriverControls {
    AndroidDriver<WebElement> driver;

    public DriverControls(AndroidDriver<WebElement> driver){
        this.driver = driver;
    }

    public void setImplicitWait(long seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void quitMyDriver(){
        driver.quit();
    }
}
