package utils;

import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DriverControls {

    AndroidDriver<AndroidElement> driver;

    public DriverControls(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
    }

    public void setImplicitWait(long seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void quitMyDriver(){
        driver.quit();
    }
}
