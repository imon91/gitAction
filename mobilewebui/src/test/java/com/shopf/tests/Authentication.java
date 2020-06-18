package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.BottomNavigationObjects;
import pageObjects.HomePageObjects;
import utils.WebAppBaseClass;


public class Authentication extends WebAppBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homepageobject;
    private BottomNavigationObjects bottomnavigationobject;



    @BeforeSuite(alwaysRun = true)
    public void resellerAndroidBeforeSuite() throws Exception{
        System.out.println("resellerAndroidBeforeSuite is called");
        androidDriver = getBaseDriver();
        setImplicitWait(20);
    }



    @BeforeClass(alwaysRun = true)
    public void authenticationSetUp(){
        System.out.println("authenticationSetUp is called");
        homepageobject = new HomePageObjects(androidDriver);
        bottomnavigationobject = new BottomNavigationObjects(androidDriver);
    }



    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData(){
        return new Object[][]{
                {"01877755590","666666"}
        };
    }



    @Test(  groups = {"Authentication.verifyAuthenticationWithValidCredentials",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With Valid Credentials",
            dataProvider = "getUserAuthenticationData" )
    public void verifyAuthenticationWithValidCredentials(String mobileNumber,String otp){
        System.out.println("verifyAuthentication is called");
        androidDriver.get("https://uatwap.shopups1.xyz/r");
        sleep(1000);
        bottomnavigationobject.clickOnBottomBarMyShopIcon();
        homepageobject.login("1877755590","666666");
    }



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With InValid Credentials",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyAuthenticationWithInvalidOtp(String mobileNumber,String otp){

        // Verification Step Pending
    }



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication By Editing The MobilNumber",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyEditMobileNumber(String mobileNumber,String otp){

        // Verification Step Pending
    }



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With ResendOTP",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyResendOTP(String mobileNumber,String otp){

        // Verification Step Pending
    }



    @AfterClass(alwaysRun = true)
    public void authenticationAfterClass(){
        System.out.println("Authentication AfterClass Is Called");
    }


    @AfterSuite(alwaysRun = true)
    public void resellerAndroidAfterSuite(){
        System.out.println("AfterSuite Is Called");
        quitBaseDriver();
    }

}
