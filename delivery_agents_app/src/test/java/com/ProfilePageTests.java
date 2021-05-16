package com;

import com.gurock.testrail.*;
import coreUtils.CoreConstants;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.DeliveryAgentsBaseClass;

import java.io.IOException;
import java.lang.reflect.Method;

public class ProfilePageTests extends DeliveryAgentsBaseClass {

    private ProfilePageObjects profilePageObjects;
    private EarningDetailsPageObjects earningDetailsPageObjects;

    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeClass(alwaysRun = true)
    public void beforeClass()
    {
        profilePageObjects = new ProfilePageObjects();
        earningDetailsPageObjects = new EarningDetailsPageObjects();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestContext iTestContext, Method method) throws NoSuchMethodException {
        System.out.println("BeforeMethod is called");
        testRailDataBuilder.beforeMethodForTestRail(iTestContext,method, ProfilePageTests.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, ITestContext ctx) throws IOException, APIException {
        System.out.println("AfterMethod is called");
        testRailDataBuilder.afterMethodForTestRail(result,ctx);
    }

    @TestRails(caseId = "882")
    @Test(groups = {CoreConstants.GROUP_SMOKE},priority = 101)
    public void verifyEarningDetailsLinkFunctionality() {
        System.out.println("Verifying Earning Details Link Functionality");
        profilePageObjects.clickEarningDetailsLink();
        String title = earningDetailsPageObjects.getTitleValue();
        System.out.println("Title : " + title);
        earningDetailsPageObjects.waitForLoading();
        Assert.assertEquals(title,"Earning Details");
    }
}
