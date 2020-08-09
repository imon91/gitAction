package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.RedXBaseClass;

public class Settings extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private SettingsPageObjects settingsPageObjects;

    public void pageInitializer()
    {
        homePageObjects = new HomePageObjects();
        settingsPageObjects = new SettingsPageObjects();
    }

    @BeforeClass(alwaysRun = true)
    public void settingsBeforeClass() throws Exception
    {
        System.out.println("Before Settings Class");
        androidDriver = getBaseDriver();
        pageInitializer();
        homePageObjects.clickSettingsButton();
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Verify Payment Details",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void verifyPaymentDetails()
    {
        System.out.println("Verifying Payment Details");
        settingsPageObjects.clickPaymentDetailsModule();
        Assert.assertEquals(settingsPageObjects.getPageTitle(),"Payment Details");
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Verify Pickup Area",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void verifyPickupArea()
    {
        System.out.println("Verifying Pickup Area");
        settingsPageObjects.clickPickupAreaModule();
        Assert.assertEquals(settingsPageObjects.getPageTitle(),"Pickup information");
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Verify Other Settings",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void verifyOtherSettings()
    {
        System.out.println("Verifying Other Settings");
        settingsPageObjects.clickOtherSettingsModule();
        Assert.assertEquals(settingsPageObjects.getPageTitle(),"Other Information");
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Verify Terms Of Delivery",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void verifyTermsOfDelivery()
    {
        System.out.println("Verifying Terms Of Delivery");
        settingsPageObjects.clickTermsOfDeliveryModule();
        Assert.assertEquals(settingsPageObjects.getPageTitle(),"Delivery Terms");
    }


    @AfterMethod(alwaysRun = true)
    public void settingsAfterTest()
    {
        settingsPageObjects.clickBackButton();
        System.out.println("After Settings Test");
    }

    @AfterClass(alwaysRun = true)
    public void afterChangeLanguageClass()
    {
        settingsPageObjects.clickBackButton();
        System.out.println("After Settings Class");
    }
}