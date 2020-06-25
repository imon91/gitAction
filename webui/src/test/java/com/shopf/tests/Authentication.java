package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import utils.WebBaseClass;


public class Authentication extends WebBaseClass {


    private WebDriver driver;
    private LoginPageObject loginPageObject;



    @BeforeSuite(alwaysRun = true)
    public void resellerAndroidBeforeSuite() throws Exception{
        System.out.println("ResellerWebBeforeSuite is called");
        driver = getBaseDriver();
        setImplicitWait(30);
    }




    @BeforeClass(alwaysRun = true)
    public void authenticationSetUp(){
        System.out.println("authenticationSetUp is called");
        loginPageObject = new LoginPageObject(driver);
        browserMaximize();
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
            CoreConstants.GROUP_INTEGRATION,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With Valid Credentials",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyAuthenticationWithValidCredentials(String mobileNumber,String otp){
        System.out.println("verifyAuthentication is called");
        driver.get(CoreConstants.RESELLER_STAGE_BASE_URL);
        sleep(4000);
        // Verification Step Pending
        loginPageObject.performAuthentication("01877755590","666666");
    }



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_INTEGRATION,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With InValid Credentials",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyAuthenticationWithInvalidOtp(String mobileNumber,String otp){

        // Verification Step Pending
    }



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_INTEGRATION,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication By Editing The MobilNumber",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyEditMobileNumber(String mobileNumber,String otp){

        // Verification Step Pending
    }



    @Test(  groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_INTEGRATION,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With ResendOTP",
            dataProvider = "getUserAuthenticationData"  )
    public void verifyResendOTP(String mobileNumber,String otp){

        // Verification Step Pending
    }



    @AfterClass(alwaysRun = true)
    public void closeAuthenticationClass(){
        System.out.println("AfterClass Is Called");

    }



    @AfterSuite(alwaysRun = true)
    public void resellerAndroidAfterSuite(){
        System.out.println("AfterSuite Is Called");
        quitBaseDriver();
    }
}
