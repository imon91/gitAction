package com.shopf.tests.Authentication;

import com.gurock.testrail.*;
import coreUtils.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

import java.io.*;
import java.lang.reflect.Method;

public class AuthenticationTests extends RedXWebBaseClass {

    private WebDriver driver;
    private LoginPageObjects loginPageObjects;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void authenticationTestsBeforeClass() throws Exception
    {
        driver = getBaseDriver();
        loginPageObjects = new LoginPageObjects(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, AuthenticationTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "13")
    @Test(groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY,CoreConstants.GROUP_SLACK_BUG},priority = 2)
    public void verifyAuthenticationWithValidCredentials()
    {
        System.out.println("Verifying Authentication with valid credentials");
        loginPageObjects.performAuthentication("0140112218","6666","8");
//        System.out.println(driver.manage().getCookies().toString());
        String url = driver.getCurrentUrl();
        System.out.println("Current URL : " + url);
        Assert.assertEquals(url,"https://redx.shopups1.xyz/dashboard/");
    }
}
