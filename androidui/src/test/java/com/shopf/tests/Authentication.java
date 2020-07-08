package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;


public class Authentication extends AndroidBaseClass {


    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;



    @BeforeSuite(alwaysRun = true)
    public void resellerAndroidBeforeSuite(){
        System.out.println("resellerAndroidBeforeSuite is called");
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
                {"01877755590","666666"}
        };
    }



    @Test(  groups = {"Authentication.verifyAuthenticationWithValidCredentials",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With Valid Credentials",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyAuthenticationWithValidCredentials(String mobileNumber,String otp){
        System.out.println("verifyAuthentication is called");
        loginPageObjects.performAuthentication(mobileNumber,otp);
        // Verification Step Pending
    }



<<<<<<< HEAD
    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
=======
    @Test(  groups = {CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
>>>>>>> 66dc0c11558ad67d33881a18accf5188bdc727d9
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With InValid Credentials",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyAuthenticationWithInvalidOtp(String mobileNumber,String otp){
        loginPageObjects.performAuthentication(mobileNumber,otp);
        // Verification Step Pending
    }



    @Test(  groups = {"Authentication.verifyEditMobileNumber",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication By Editing The MobilNumber",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyEditMobileNumber(String mobileNumber,String otp){
        System.out.println("verifyEditMobileNumber is called");
        loginPageObjects.performEditMobileNumberFunctionality(mobileNumber,otp);
        // Verification Step Pending
    }



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With ResendOTP",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyResendOTP(String mobileNumber,String otp){
        loginPageObjects.performAuthentication(mobileNumber,otp);
        // Verification Step Pending
    }



    @AfterClass(alwaysRun = true)
    public void closeAuthenticationClass(){
        System.out.println("AuthenticationAfter Is Called");
        //closeApp();
    }



    @AfterSuite(alwaysRun = true)
    public void resellerAndroidAfterSuite(){
        System.out.println("AfterSuite Is Called");
        quitBaseDriver();
    }


}
