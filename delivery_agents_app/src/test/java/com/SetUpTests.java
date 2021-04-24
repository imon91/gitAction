package com;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import utils.*;

public class SetUpTests extends DeliveryAgentsBaseClass {

    private AndroidDriver<WebElement> androidDriver;

    @BeforeSuite(alwaysRun = true)
    public void deliveryAgentsAndroidBeforeSuite()
    {
        System.out.println("Delivery Agents Before Suite");
        androidDriver = getBaseDriver();
    }

    @Test(groups = {CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SANITY},priority = 1)
    public void setUpTests()
    {
        System.out.println("Setting Up Tests");
    }

    @AfterSuite(alwaysRun = true)
    public void deliveryAgentsAndroidAfterSuite()
    {
        System.out.println("Delivery Agents Before Suite");
        quitBaseDriver();
    }
}
