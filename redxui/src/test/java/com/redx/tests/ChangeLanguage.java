package com.redx.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class ChangeLanguage extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private SettingsPageObjects settingsPageObjects;
    private SettingsPageObjects.OtherSettings otherSettings;
    private Authentication authentication;

    public void pageInitializer()
    {
        homePageObjects = new HomePageObjects();
        settingsPageObjects = new SettingsPageObjects();
        otherSettings = settingsPageObjects.new OtherSettings();
        authentication = new Authentication();
    }

    @BeforeSuite(alwaysRun = true)
    public void redXAndroidBeforeSuite()
    {
        System.out.println("redXAndroidBeforeSuite is called");
        androidDriver = getBaseDriver();
    }

    @BeforeClass(alwaysRun = true)
    public void beforeChangeLanguageClass() throws Exception
    {
        System.out.println("Before Change Language Class");
        androidDriver = getBaseDriver();
        pageInitializer();
    }

    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData(){
        return new Object[][]{
                {"01401122188","6666"}
        };
    }

    @Test(  groups = {"Authentication.verifyAuthenticationWithValidCredentials",
            CoreConstants.GROUP_SANITY},
            description = "Verifies Authentication With Valid Credentials",
            priority = 1,
            dataProvider = "getUserAuthenticationData")
    public void verifyAuthenticationWithValidCredentials(String mobileNumber,String otp) throws Exception {
        System.out.println("Verify Authentication is called");
        authentication.authenticationSetUp();
    authentication.verifyAuthenticationWithValidCredentials(mobileNumber,otp);}

    @Test(  groups = {"Settings.verifyChangeLanguageToENGLISH",
            CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION,CoreConstants.GROUP_SANITY},
            description = "Change Language To English",
            priority = 2)
    public void changeToEnglishLanguage()
    {
        System.out.println("Changing to English Language");
        homePageObjects.clickSettingsButton();
        otherSettings.changeToEnglish();
        settingsPageObjects.clickBackButton();
        sleep(2000);
        settingsPageObjects.clickBackButton();
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY, CoreConstants.GROUP_REGRESSION},
            priority = 3,
            description = "Change Language To Bangla")
    public void changeToBanglaLanguage()
    {
        System.out.println("Changing to Bangla Language");
        homePageObjects.clickSettingsButton();
        otherSettings.changeToBangla();
    }


    @AfterClass(alwaysRun = true)
    public void afterChangeLanguageClass()
    {
        System.out.println("After Change Language Class");
    }

    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){
        System.out.println("redXAndroidAfterSuite Is Called");
        quitBaseDriver();

    }



}
