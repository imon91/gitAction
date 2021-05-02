package com;

import com.gurock.testrail.TestRailDataBuilder;
import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.*;

public class SetUpTests extends DeliveryAgentsBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private TestRailDataBuilder testRailDataBuilder = TestRailDataBuilder.getInstance();

    @BeforeSuite(alwaysRun = true)
    public void deliveryAgentsAndroidBeforeSuite(ITestContext iTestContext) throws Exception
    {
        System.out.println("Delivery Agents Before Suite");
        testRailDataBuilder.setUpTestRail(iTestContext);
        androidDriver = getBaseDriver();

    }

    @Test(groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},priority = 1)
    public void setUpTests()
    {
        System.out.println("Setting Up Tests");
    }

    @AfterSuite(alwaysRun = true)
    public void deliveryAgentsAndroidAfterSuite() throws Exception
    {
        System.out.println("Delivery Agents Before Suite");
        testRailDataBuilder.tearDownTestRail();
        quitBaseDriver();
    }
}
