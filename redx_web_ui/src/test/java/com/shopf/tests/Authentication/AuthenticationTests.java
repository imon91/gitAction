package com.shopf.tests.Authentication;

import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class AuthenticationTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;

    @BeforeSuite(alwaysRun = true)
    public void redxBeforeSuite() throws Exception{
        System.out.println("RedX Web Before Suite is called");
            driver = getBaseDriver();
            setImplicitWait(10000);
            driver.get(getWebBaseUrl());
    }

    @BeforeClass(alwaysRun = true)
    public void authenticationTestsBeforeClass(){
        loginPageObjects = new LoginPageObjects(driver);
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY})
    public void verifyAuthenticationWithValidCredentials() throws InterruptedException{
        System.out.println("Verify Authentication with valid credentials was called");
        loginPageObjects.performAuthentication("0140112217","6666","7");
    }

    @Test
    public void verifyAuthenticationWithInvalidCredentials(){

    }

    @AfterClass(alwaysRun = true)
    public void authenticationTestsAfterClass(){

    }

    @AfterSuite(alwaysRun = true)
    public void redxAfterSuite(){
        System.out.println("RedX Web After Suite is called");
        quitBaseDriver();
    }
}
