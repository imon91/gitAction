package com.shopf.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.BottomNavigationObjects;
import pageObjects.HomePageObjects;
import utils.WAPConstants;
import utils.WebAppBaseClass;


public class Authentication extends WebAppBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homepageobject;
    private BottomNavigationObjects bottomnavigationobject;



    @BeforeSuite(alwaysRun = true)
    public void resellerAndroidBeforeSuite() throws Exception{
        System.out.println("resellerAndroidBeforeSuite is called");
        androidDriver = getBaseDriver();
        androidDriver.get(getWAPBaseUrl()+"r");
        setImplicitWait(30);
    }



    @BeforeClass(alwaysRun = true)
    public void authenticationSetUp() throws Exception {
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



    @Test(  groups = {"Authentication.verifyAuthenticationUrl",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION},
            description = "Verify URL of Authentication page")
    public void verifyAuthenticationUrl(){
        System.out.println("verifyAuthentication is called");
        bottomnavigationobject.clickOnBottomBarMyOrdersIcon();
        String currentPage = androidDriver.getCurrentUrl();
        Assert.assertTrue(currentPage.contains(WAPConstants.AUTHENTICATION));
        System.out.println("Control is in Authentication page");
    }



    @Test(  groups = {"Authentication.verifyAuthenticationWithValidCredentials",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With Valid Credentials",
            dataProvider = "getUserAuthenticationData", dependsOnMethods = "verifyAuthenticationUrl")
    public void verifyAuthenticationWithValidCredentials(String mobileNumber,String otp){
        homepageobject.login(mobileNumber, otp);
        sleep(1000);
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
