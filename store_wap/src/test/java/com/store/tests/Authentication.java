package com.store.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObejcts.AuthenticationPageObjects;
import services.commerceMethods.GetAuthenticationApiResponse;
import utils.StoreWapBaseClass;

public class Authentication extends StoreWapBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private AuthenticationPageObjects authenticationPageObjects;


    @BeforeSuite(alwaysRun = true)
    public void resellerAndroidBeforeSuite() throws Exception {
        System.out.println("resellerAndroidBeforeSuite is called");
        // This code is to set the Cookie for API usage
        new GetAuthenticationApiResponse(CoreConstants.MODULE_STORE_WAP).performAuthentication();
        androidDriver = getBaseDriver();
        androidDriver.get(getWAPBaseUrl());
        setImplicitWait(30);
    }


    @BeforeClass(alwaysRun = true)
    public void authenticationSetUp() throws Exception {
        System.out.println("authenticationSetUp is called");
        authenticationPageObjects = new AuthenticationPageObjects(androidDriver);
    }


    @DataProvider(name = "dataForAuthentication")
    public Object[][] dataForAuthentication() {
        return new Object[][]{
                {"8801877755580"}
        };
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dataProvider = "dataForAuthentication")
    public void authenticationWithValidCredentials(String mobileNumber) {
        System.out.println("Welcome To Store WAP Testing Vishnuvarthan!!" );
        System.out.println("authenticationWithValidCredentials is called");
        authenticationPageObjects.sendOtp(mobileNumber);
        Assert.assertEquals(authenticationPageObjects.getOtpStatusMessage(), "otp sent successfully");
        authenticationPageObjects.enterValidOtp();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dataProvider = "dataForAuthentication", enabled = false)
    public void verifyResendOTPFunctionality(String mobileNumber) {
        System.out.println("verifyResendOTPFunctionality is called");
        authenticationPageObjects.sendOtp(mobileNumber);
        Assert.assertEquals(authenticationPageObjects.getOtpStatusMessage(), "otp sent succesfully");
        authenticationPageObjects.enterValidResendOtp();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dataProvider = "dataForAuthentication", enabled = false)
    public void authenticationWithInvalidOTP(String mobileNumber) {
        System.out.println("authenticationWithInvalidOTP is called");
        authenticationPageObjects.sendOtp(mobileNumber);
        Assert.assertEquals(authenticationPageObjects.getOtpStatusMessage(), "otp sent succesfully");
        authenticationPageObjects.enterInValidOtp();
        System.out.println("Logging in with valid otp");
        authenticationPageObjects.sendOtp(mobileNumber);
        Assert.assertEquals(authenticationPageObjects.getOtpStatusMessage(), "otp sent succesfully");
        authenticationPageObjects.enterValidOtp();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dataProvider = "dataForAuthentication", enabled = false)
    public void verifyInvalidResendOTPFunctionality(String mobileNumber) {
        System.out.println("verifyInvalidResendOTPFunctionality is called");
        authenticationPageObjects.sendOtp(mobileNumber);
        Assert.assertEquals(authenticationPageObjects.getOtpStatusMessage(), "otp sent succesfully");
        authenticationPageObjects.enterInValidResendOtp();
        System.out.println("Logging in with valid otp");
        authenticationPageObjects.sendOtp(mobileNumber);
        Assert.assertEquals(authenticationPageObjects.getOtpStatusMessage(), "otp sent succesfully");
        authenticationPageObjects.enterValidOtp();
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE}, dataProvider = "dataForAuthentication", enabled = false)
    public void verifyLoginWithInvalidMobileNumber(String mobileNumber) {
        System.out.println("verifyLoginWithInvalidMobileNumber is called");
        authenticationPageObjects.sendOtpInvalidMobileNumber();
        authenticationPageObjects.clearMobileNumberField(mobileNumber);
        System.out.println("Logging in with valid Mobile Number");
        Assert.assertEquals(authenticationPageObjects.getOtpStatusMessage(), "otp sent succesfully");
        authenticationPageObjects.enterValidOtp();
    }


    @AfterClass(alwaysRun = true)
    public void authenticationAfterClass() {
        System.out.println("Authentication AfterClass Is Called");
    }


}
