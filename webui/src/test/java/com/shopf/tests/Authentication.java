package com.shopf.tests;

import coreUtils.CoreConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.LoginPageObject;
import utils.WebBaseClass;


public class Authentication extends WebBaseClass {


    private WebDriver driver;
    private LoginPageObject loginPageObject;



    @BeforeSuite(alwaysRun = true)
    public void resellerWebBeforeSuite() throws Exception {
        System.out.println("ResellerWebBeforeSuite is called");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getWebBaseUrl());
    }



    @BeforeClass(alwaysRun = true)
    public void authenticationSetUp() {
        System.out.println("authenticationBeforeclass is called");
        loginPageObject = new LoginPageObject(driver);
        browserMaximize();
    }



    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData() {
        return new Object[][]{
                {"01877755590", "666666"}
        };
    }



    @Test(groups = {"Authentication.verifyAuthenticationWithValidCredentials",
            CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_INTEGRATION,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With Valid Credentials",
            dataProvider = "getUserAuthenticationData")
    public void verifyAuthenticationWithValidCredentials(String mobileNumber, String otp) {
        System.out.println("verifyAuthentication is called");
        sleep(1000);
        loginPageObject.performAuthentication("01877755590", "666666");
        // Verification Step Pending
    
    }



    @Test(groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_INTEGRATION,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With InValid Credentials",
            dataProvider = "getUserAuthenticationData")
    public void verifyAuthenticationWithInvalidOtp(String mobileNumber, String otp) {

        // Verification Step Pending
    }



    @Test(groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_INTEGRATION,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication By Editing The MobilNumber",
            dataProvider = "getUserAuthenticationData")
    public void verifyEditMobileNumber(String mobileNumber, String otp) {

        // Verification Step Pending
    }



    @Test(groups = {CoreConstants.GROUP_FUNCTIONAL,
            CoreConstants.GROUP_INTEGRATION,
            CoreConstants.GROUP_REGRESSION},
            description = "Verifies Authentication With ResendOTP",
            dataProvider = "getUserAuthenticationData")
    public void verifyResendOTP(String mobileNumber, String otp) {

        // Verification Step Pending
    }



    @AfterClass(alwaysRun = true)
    public void closeAuthenticationClass() {
        System.out.println("AfterClass Is Called");

    }



    @AfterSuite(alwaysRun = true)
    public void resellerWebAfterSuite() {
        System.out.println("AfterSuite Is Called");
        quitBaseDriver();
    }


}
