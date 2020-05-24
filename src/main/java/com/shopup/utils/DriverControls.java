package com.shopup.utils;

import java.util.concurrent.TimeUnit;
import io.appium.java_client.AppiumDriver;

public class DriverControls {

    AppiumDriver driver;

    public DriverControls(AppiumDriver driver){
        this.driver = driver;
    }

    public void setImplicitWait(long seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
}
