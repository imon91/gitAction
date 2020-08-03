package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.*;
import utils.RedXBaseClass;

public class Logout extends RedXBaseClass
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
    public void beforeLogoutClass() throws Exception
    {
        System.out.println("Before Logout Class");
        androidDriver = getBaseDriver();
        pageInitializer();
        homePageObjects.clickSettingsButton();
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Verify Cancel Logout",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void verifyCancelLogout()
    {
        System.out.println("Verifying Cancel Logout");
        settingsPageObjects.clickLogoutButton();
        settingsPageObjects.clickCancelButton();
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Verify Confirm Logout",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void verifyConfirmLogout()
    {
        System.out.println("Verifying Confirm Logout");
        settingsPageObjects.performLogout();
    }

    @AfterClass(alwaysRun = true)
    public void afterLogoutClass()
    {
        System.out.println("After Logout Class");
    }
}
