package com.shopf.tests;

import auth.*;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import utils.*;
import pageObjects.*;


public class Login extends WmsBaseClass {

    private WebDriver driver;
    private LoginPageObject loginPageObject;
    String ck;

    @BeforeSuite(alwaysRun = true)
    public void wmsBeforeSuite() throws Exception {
        System.out.println("WMSBeforeSuite is called");
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getWmsBaseUrl());
        driver.manage().window().fullscreen();
    }


    @BeforeClass(alwaysRun = true)
    public void loginBeforeClass() {
        System.out.println("Login Before Class is called");
        loginPageObject = new LoginPageObject(driver);
    }


    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData() {
        return new Object[][]{
                {"operator1@voonik.com", "password"}
        };
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE,
            CoreConstants.GROUP_SANITY,
            CoreConstants.GROUP_REGRESSION,
            CoreConstants.GROUP_FUNCTIONAL,
            "Login.verifyAuthenticationWithValidCredentials"},
            description = "Verify Authentication with Valid Credentials",
            dataProvider = "getUserAuthenticationData"
    )
    public void verifyAuthenticationWithValidCredentials(String email, String password) throws Exception {
        System.out.println("verifyAuthentication is called");
        loginPageObject.performLogin(email, password);
        sleep(1000);
        String url = driver.getCurrentUrl();
        System.out.println(email + ":" + password);
        System.out.println(url);
        sleep(1000);
        for(Cookie cookie : driver.manage().getCookies()){
            ck = cookie.getName() + "=" + cookie.getValue() + ";Path=/; HttpOnly" ;
            System.out.println(ck);
        }
        CookieManager.setValue("WMS_COOKIE",ck);
    }

    @AfterClass(alwaysRun = true)
    public void loginAfterClass() {
        System.out.println("LoginAfterClass Is Called");
    }


    @AfterSuite(alwaysRun = true)
    public void wmsAfterSuite() {
        System.out.println("WMSAfterSuite Is Called");
        quitBaseDriver();
    }
}