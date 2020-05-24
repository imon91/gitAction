package com.shopup.shopUpAndroid.functionalTests.authentication;

import com.shopup.shopUpAndroid.pageObjects.LoginPageObjects;
import com.shopup.utils.BaseClass;
import com.shopup.utils.CommonUtils;
import com.shopup.utils.DriverControls;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VerifyAuthentication extends BaseClass {

    private AndroidDriver androidDriver;
    private DriverControls driverControls;
    private LoginPageObjects loginPageObjects;


    @BeforeSuite
    public void setUp() throws Exception{

        // 1 : Start Appium Service
        startService();

        // 2 : Get Driver
        androidDriver = getDriver();

        // 3 : Set DriverControls
        driverControls = new DriverControls(androidDriver);


        loginPageObjects = new LoginPageObjects(androidDriver);


    }


    @Test
    public void verifyAuthentication(){
        // Set Implicit Wait
        driverControls.setImplicitWait(10);
        //loginPageObjects.performAuthentication("1877755590","666666");
        //loginPageObjects.
    }



    @AfterSuite
    public void tearDown(){
        stopService();
        CommonUtils.threadSleep(3000);
        androidDriver.quit();
    }
}
