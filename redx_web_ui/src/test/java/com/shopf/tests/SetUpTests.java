package com.shopf.tests;

import auth.CookieManager;
import com.gurock.testrail.TestRailDataBuilder;
import coreUtils.CoreConstants;
import org.openqa.selenium.*;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import services.redxMethods.GetRedxApiResponse;
import utils.RedXWebBaseClass;

public class SetUpTests extends RedXWebBaseClass {

    private WebDriver driver;
    private GetRedxApiResponse getRedxApiResponse;
    private String cookie;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeSuite(alwaysRun = true)
    public void redxBeforeSuite(ITestContext iTestContext) throws Exception
    {
        System.out.println("RedX Web Before Suite");
        testRailDataBuilder.setUpTestRail(iTestContext);
        driver = getBaseDriver();
        setImplicitWait(10000);
        driver.get(getWebBaseUrl());
        driver.manage().window().maximize();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SANITY},priority = 1)
    public void setUpTests() throws Exception
    {
        System.out.println("Setting Up Tests");
//        getRedxApiResponse = new GetRedxApiResponse("redxweb");
//        cookie = getRedxApiResponse.performAuthentication("1401122188","6666");
//        System.out.println("Cookie : " + cookie);
//        try {
//            CookieManager.setValue(CookieManager.Keys.RED_X_COOKIE,cookie);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Cookie ck = new Cookie("__ti__",CookieManager.getValueOfKey(CookieManager.Keys.RED_X_COOKIE));
//        driver.manage().addCookie(ck);
//        System.out.println(driver.manage().getCookies().toString());
//        driver.navigate().refresh();
    }

    @AfterSuite(alwaysRun = true)
    public void redxWebAfterSuite() throws Exception
    {
        System.out.println("RedX Web After Suite");
        testRailDataBuilder.tearDownTestRail();
        quitBaseDriver();
    }
}
