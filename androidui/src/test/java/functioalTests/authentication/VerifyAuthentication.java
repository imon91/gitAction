package com.shopup.resellerAndroid.functionalTests.authentication;

import pageObjects.LoginPageObjects;
import utils.BaseClass;
import utils.DriverControls;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyAuthentication extends BaseClass {

    private AndroidDriver<AndroidElement> androidDriver;
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

    @DataProvider(name = "dataForLoginFunctionality")
    public Object[][] dataForLoginFunctionality(){
        return new Object[][]{
                {"1877755590","666666"}
        };

        }


    @Test(enabled = true,dataProvider = "dataForLoginFunctionality")
    public void verifyAuthentication(String mobile,String otp){
        // Set Implicit Wait
        driverControls.setImplicitWait(10);
        loginPageObjects.performAuthentication(mobile,otp);
    }



    @AfterSuite
    public void tearDown() throws Exception{
        Thread.sleep(1000);
        stopService();
//        CommonUtils.threadSleep(10000);
//        androidDriver.quit();
    }
}
