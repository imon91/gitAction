package com.shopf.tests;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;
import videoRecorder.*;

public class LoginAdminPanel extends OmsBaseClass {

    private WebDriver driver;
    private LoginPageObject loginPageObject;


    @BeforeSuite(alwaysRun = true)
    public void wmsBeforeSuite() throws Exception {
        System.out.println("OMSBeforeSuite is called");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getOmsBaseUrl());
        ScreenRecorder.startRecording("OMS");
    }


    @BeforeClass(alwaysRun = true)
    public void loginBeforeClass() {
        System.out.println("Login Before Class is called");
        loginPageObject = new LoginPageObject(driver);
    }


    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData() {
        return new Object[][]{
                {"jnikhilyeah_bt@mepcoeng.ac.in", "gtasagta"}
        };
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION,
            "Login.verifyAuthenticationWithValidCredentials"},
            description = "Verify Authentication with Valid Credentials",
            dataProvider = "getUserAuthenticationData"
    )
    public void verifyAuthenticationWithValidCredentials(String email, String password) throws Exception {
        System.out.println("verifyAuthentication is called");
        loginPageObject.performLogin(email, password);
        String url = driver.getCurrentUrl();
        System.out.println(url);
    }

    @AfterClass(alwaysRun = true)
    public void loginAfterClass() {
        System.out.println("LoginAfterClass Is Called");
    }


    @AfterSuite(alwaysRun = true)
    public void wmsAfterSuite() throws Exception {
        System.out.println("OMSAfterSuite Is Called");
        ScreenRecorder.stopRecording();
        quitBaseDriver();
    }
}