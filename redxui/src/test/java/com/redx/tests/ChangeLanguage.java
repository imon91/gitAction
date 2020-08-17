package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pageObjects.*;
import utils.RedXBaseClass;

public class ChangeLanguage extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private SettingsPageObjects settingsPageObjects;
    private SettingsPageObjects.OtherSettings otherSettings;

    public void pageInitializer()
    {
        homePageObjects = new HomePageObjects();
        settingsPageObjects = new SettingsPageObjects();
        otherSettings = settingsPageObjects.new OtherSettings();
    }

    @BeforeClass(alwaysRun = true)
    public void beforeChangeLanguageClass() throws Exception
    {
        System.out.println("Before Change Language Class");
        androidDriver = getBaseDriver();
        pageInitializer();
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Change Language To English",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void changeToEnglishLanguage()
    {
        System.out.println("Changing to English Language");
        homePageObjects.clickSettingsButton();
        otherSettings.changeToEnglish();
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY, CoreConstants.GROUP_REGRESSION},
            description = "Change Language To Bangla",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void changeToBanglaLanguage()
    {
        System.out.println("Changing to Bangla Language");
        homePageObjects.clickSettingsButton();
        otherSettings.changeToBangla();
    }


    @AfterClass(alwaysRun = true)
    public void afterChangeLanguageClass()
    {
        settingsPageObjects.clickBackButton();
        settingsPageObjects.clickBackButton();
        System.out.println("After Change Language Class");
    }
}
