package com.redx.tests;

import coreUtils.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class Authentication extends RedXBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;



    @BeforeSuite(alwaysRun = true)
    public void redXAndroidBeforeSuite(){
        System.out.println("redXAndroidBeforeSuite is called");
        androidDriver = getBaseDriver();
    }

    public void pageInitializer(){
        loginPageObjects = new LoginPageObjects(androidDriver);
    }


    @BeforeClass(alwaysRun = true)
    public void authenticationSetUp() throws Exception{
        System.out.println("authenticationSetUp is called");
        pageInitializer();
    }



    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData(){
        return new Object[][]{
                {"01401122188","6666"}
        };
    }



    @Test(  groups = {"Authentication.verifyAuthenticationWithValidCredentials",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With Valid Credentials",
            dataProvider = "getUserAuthenticationData")
    public void verifyAuthenticationWithValidCredentials(String mobileNumber,String otp){
        System.out.println("verifyAuthentication is called");
//        loginPageObjects.performAuthentication(mobileNumber,otp);

    }

    @AfterClass(alwaysRun = true)
    public void closeAuthenticationClass(){
        System.out.println("AuthenticationAfterClass Is Called");
        //closeApp();
    }



    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){
        System.out.println("redXAndroidAfterSuite Is Called");
        sleep(15000);
        quitBaseDriver();
    }

}
