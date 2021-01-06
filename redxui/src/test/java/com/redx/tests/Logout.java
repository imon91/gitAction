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
    private Authentication authentication;
    private ChangeLanguage   changeLanguage;

    public void pageInitializer()
    {
        homePageObjects = new HomePageObjects();
        settingsPageObjects = new SettingsPageObjects();
        settingsPageObjects = new SettingsPageObjects();
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
    public void beforeLogoutClass() throws Exception
    {
        System.out.println("Before Logout Class");
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

    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){

        System.out.println("redXAndroidAfterSuite Is Called");
        quitBaseDriver();

    }
}
