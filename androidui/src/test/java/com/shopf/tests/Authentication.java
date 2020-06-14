package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.*;
import pageObjects.*;
import utils.AndroidBaseClass;

public class Authentication extends AndroidBaseClass {


    private AndroidDriver<AndroidElement> androidDriver;
    private LoginPageObjects loginPageObjects;



    @BeforeSuite(alwaysRun = true)
    public void resellerAndroidBeforeSuite(){
        System.out.println("resellerAndroidBeforeSuite is called");
    }



    @BeforeClass(alwaysRun = true)
    public void authenticationSetUp() throws Exception{
        System.out.println("authenticationSetUp is called");
        androidDriver = getBaseDriver();
        setImplicitWait(10);
        loginPageObjects = new LoginPageObjects(androidDriver);
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



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With InValid Credentials",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyAuthenticationWithInvalidOtp(String mobileNumber,String otp){
        loginPageObjects.performAuthentication(mobileNumber,otp);
        // Verification Step Pending
    }



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication By Editing The MobilNumber",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyEditMobileNumber(String mobileNumber,String otp){
        loginPageObjects.performAuthentication(mobileNumber,otp);
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
        System.out.println("AfterSuite Is Called");
        // Update Driver to Shared place
        //System.out.println("Driver is Updated from AuthenticationClass");
    }



    @AfterSuite(alwaysRun = true)
    public void resellerAndroidAfterSuite(){
        System.out.println("AfterSuite Is Called");
        quitBaseDriver();
    }


}
