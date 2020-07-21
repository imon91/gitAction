package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.SettingsPageObjects;
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
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Logout Test",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void verifyLogout()
    {
        System.out.println("Verifying Logout");
        homePageObjects.clickSettingsButton();
        settingsPageObjects.performLogout();
    }

    @AfterClass(alwaysRun = true)
    public void afterLogoutClass()
    {
        System.out.println("After Logout Class");
    }
}
