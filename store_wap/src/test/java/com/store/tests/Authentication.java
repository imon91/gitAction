package com.store.tests;

import coreUtils.CoreConstants;
import dataBase.DataBaseCore;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObejcts.AuthenticationPageObjects;
import services.commerceMethods.GetAuthenticationApiResponse;
import services.commerceMethods.GetCommerceApiResponse;
import utils.StoreWapBaseClass;

public class Authentication extends StoreWapBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private AuthenticationPageObjects authenticationPageObjects;


    @BeforeSuite(alwaysRun = true)
    public void resellerAndroidBeforeSuite() throws Exception{
        System.out.println("resellerAndroidBeforeSuite is called");
        // This code is to set the Cookie for API usage
        new GetAuthenticationApiResponse(CoreConstants.MODULE_STORE_WAP)
                .performAuthentication();
        androidDriver = getBaseDriver();
        androidDriver.get(getWAPBaseUrl());
        setImplicitWait(30);
    }


    @BeforeClass(alwaysRun = true)
    public void authenticationSetUp() throws Exception {
        System.out.println("authenticationSetUp is called");
        authenticationPageObjects = new AuthenticationPageObjects();
    }


    @DataProvider(name = "dataForAuthentication")
    public Object[][] dataForAuthentication(){
        return new Object[][]{
                {"01877755590"}
        };
    }


    @Test(groups = {CoreConstants.GROUP_SMOKE},dataProvider = "dataForAuthentication")
    public void startYouTests(String mobileNumber){
        System.out.println("Welcome To Store WAP Testing Vishnuvarthan!!");
        authenticationPageObjects.performAuthentication(mobileNumber);
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
