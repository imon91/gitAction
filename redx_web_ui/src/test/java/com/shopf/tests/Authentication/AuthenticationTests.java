package com.shopf.tests.Authentication;

import coreUtils.CoreConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.RedXWebBaseClass;

public class AuthenticationTests extends RedXWebBaseClass {

    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void redxBeforeSuite() throws Exception{
        System.out.println("Stores BeforeSuite is called");
            driver = getBaseDriver();
            setImplicitWait(10000);
            driver.get(getWebBaseUrl());
    }

    @BeforeClass(alwaysRun = true)
    public void authenticationTestsBeforeClass(){

    }

    @Test(groups = CoreConstants.GROUP_SMOKE)
    public void verifyAuthenticationWithValidCredentials(){
        System.out.println("Welcome to RedX Web Asoka");
    }

    @Test
    public void verifyAuthenticationWithInvalidCredentials(){

    }

    @AfterClass(alwaysRun = true)
    public void authenticationTestsAfterClass(){

    }

    @AfterSuite(alwaysRun = true)
    public void redxAfterSuite(){
        System.out.println("Stores AfterSuite is called");
        quitBaseDriver();
    }
}
