package com.redx.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class Settings extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private SettingsPageObjects settingsPageObjects;
    private LoginPageObjects loginPageObjects;
    private SettingsPageObjects.OtherSettings otherSettings;
    private Authentication authentication;
    private ChangeLanguage changeLanguage;

    public void pageInitializer()
    {
        homePageObjects = new HomePageObjects();
        settingsPageObjects = new SettingsPageObjects();
        loginPageObjects = new LoginPageObjects();
        settingsPageObjects = new SettingsPageObjects();
        otherSettings = settingsPageObjects.new OtherSettings();
        authentication = new Authentication();
        changeLanguage = new ChangeLanguage();

    }

    @BeforeSuite(alwaysRun = true)
    public void redXAndroidBeforeSuite()
    {
        System.out.println("redXAndroidBeforeSuite is called");
        androidDriver = getBaseDriver();
    }

    @BeforeClass(alwaysRun = true)
    public void settingsBeforeClass() throws Exception
    {
        System.out.println("Before Settings Class");
        androidDriver = getBaseDriver();
        pageInitializer();
        homePageObjects.clickSettingsButton();
    }

    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData(){
        return new Object[][]{
                {"01401122188","6666"}
        };
    }

    @Test(  groups = {"Authentication.verifyAuthenticationWithWrongOTP",
            CoreConstants.GROUP_SANITY},
            description = "Verifies Authentication With Wrong OTP",
            priority = 1,
            dataProvider = "getUserAuthenticationData")
    public void verifyAuthenticationWithWrongOTP(String mobileNumber,String otp) throws Exception {
        System.out.println("Verify authentication with Wrong OTP was called");
        authentication.authenticationSetUp();
        authentication.verifyAuthenticationWithValidCredentials(mobileNumber,otp);}

    @Test(  groups = {"Settings.verifyChangeLanguageToENGLISH",
            CoreConstants.GROUP_SANITY},
            description = "Change Language To English",
            priority = 2)
    public void changeToEnglishLanguage() throws Exception {
        System.out.println("Changing to English Language");
        changeLanguage.beforeChangeLanguageClass();
        changeLanguage.changeToEnglishLanguage();
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Verify Payment Details",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void verifyPaymentDetails()
    {
        System.out.println("Verifying Payment Details");
        settingsPageObjects.clickPaymentDetailsModule();
        Assert.assertEquals(settingsPageObjects.getPageTitle(),"Payment Details");
        settingsPageObjects.clickBackButton();
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Verify Pickup Area",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void verifyPickupArea()
    {
        System.out.println("Verifying Pickup Area");
        settingsPageObjects.clickPickupAreaModule();
        Assert.assertEquals(settingsPageObjects.getPageTitle(),"Pickup information");
        settingsPageObjects.clickBackButton();
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Verify Other Settings",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void verifyOtherSettings()
    {
        System.out.println("Verifying Other Settings");
        settingsPageObjects.clickOtherSettingsModule();
        Assert.assertEquals(settingsPageObjects.getPageTitle(),"Other Information");
        settingsPageObjects.clickBackButton();
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Verify Terms Of Delivery",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void verifyTermsOfDelivery()
    {
        System.out.println("Verifying Terms Of Delivery");
        settingsPageObjects.clickTermsOfDeliveryModule();
        Assert.assertEquals(settingsPageObjects.getPageTitle(),"Delivery Terms");
        settingsPageObjects.clickBackButton();
        sleep(500);
        settingsPageObjects.clickBackButton();
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

    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){

        System.out.println("redXAndroidAfterSuite Is Called");
        quitBaseDriver();

    }
}