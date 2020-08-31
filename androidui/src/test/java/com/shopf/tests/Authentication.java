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
    private ServiceRequestLayer serviceRequestLayer;


    @BeforeSuite(alwaysRun = true)
    public void resellerAndroidBeforeSuite(){
        System.out.println("resellerAndroidBeforeSuite is called");
        androidDriver = getBaseDriver();
        try{
            PropertyReader.flushDynamicData();
        }catch (Exception e){
            System.out.println("Exception at ResellerAndroidBeforeSuite : flushDynamicData");
        }
        serviceRequestLayer = new ServiceRequestLayer();
        serviceRequestLayer.getControlOverAuthentication()
                .performAuthentication();
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
                {"1877755590","666666"}
        };
    }



    @Test(  groups = {"Authentication.verifyAuthenticationWithValidCredentials",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With Valid Credentials",
            dataProvider = "getUserAuthenticationData")
    public void verifyAuthenticationWithValidCredentials(String mobileNumber,String otp){
        System.out.println("verifyAuthentication is called");
        loginPageObjects.performAuthentication(mobileNumber,otp);
        // Verification Step Pending
    }



    @Test(  groups = {CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},enabled = false,
            description = "Verifies Authentication With InValid Credentials",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyAuthenticationWithInvalidOtp(String mobileNumber,String otp1){
        loginPageObjects.performWrongOTPFunctionality(mobileNumber,otp1);
        // Verification Step Pending
    }



    @Test(  groups = {"Authentication.verifyEditMobileNumber",
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},enabled = false,
            description = "Verifies Authentication By Editing The MobilNumber",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyEditMobileNumber(String mobileNumber,String otp){
        System.out.println("verifyEditMobileNumber is called");
        loginPageObjects.performEditMobileNumberFunctionality(mobileNumber,otp);
        // Verification Step Pending
    }



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},enabled = false,
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
