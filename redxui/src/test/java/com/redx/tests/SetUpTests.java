package com.redx.tests;

import coreUtils.CoreConstants;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;

public class SetUpTests extends RedXBaseClass {

    private AndroidDriver<WebElement> androidDriver;
    private LoginPageObjects loginPageObjects;
    private HomePageObjects homePageObjects;
    private HomePageObjects.ChooseShopModule chooseShopModule;
    private SettingsPageObjects settingsPageObjects;
    private SettingsPageObjects.OtherSettings otherSettings;

    public void pageInitializer()
    {
        loginPageObjects = new LoginPageObjects();
        homePageObjects = new HomePageObjects();
        chooseShopModule = homePageObjects.new ChooseShopModule();
        settingsPageObjects = new SettingsPageObjects();
        otherSettings = settingsPageObjects.new OtherSettings();
    }

    @BeforeSuite(alwaysRun = true)
    public void redXAndroidBeforeSuite()
    {
        System.out.println("RedX Before Suite");
        androidDriver = getBaseDriver();
    }

    @BeforeClass(alwaysRun = true)
    public void authenticationSetUp() throws Exception
    {
        System.out.println("authenticationSetUp is called");
        pageInitializer();
        switchFromWebToNative();
        sleep(8000);
        loginPageObjects.verifyUpdate();
        sleep(3000);
    }

    @DataProvider(name = "getUserAuthenticationData")
    public Object[][] getUserAuthenticationData(){
        return new Object[][]{
                {"01401122188","6666"}
        };
    }

    @Test(  groups = { CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SLACK_BUG },
            description = "Verify Authentication With Valid Credentials",
            priority = 1, dataProvider = "getUserAuthenticationData")
    public void verifyAuthenticationWithValidCredentials(String mobileNumber,String otp)
    {
        System.out.println("Verify Authentication is called");
        loginPageObjects.performAuthentication(mobileNumber,otp);
        System.out.println(homePageObjects.getCurrentShopName());   }

    @Test(  groups = { CoreConstants.GROUP_SMOKE,CoreConstants.GROUP_SLACK_BUG },
            description = "Change Language To English",  priority = 2)
    public void changeToEnglishLanguage()
    {
        System.out.println("Changing to English Language");
        homePageObjects.clickSettingsButton();
        otherSettings.changeToEnglish();
        settingsPageObjects.clickBackButton();
        sleep(2000);
        settingsPageObjects.clickBackButton();
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_SLACK_BUG},
             description = "Verify Shop Name", priority = 3)
    public void verifyShopName()
    {
        String assertVariable = null;
        System.out.println("Verifying Shop Name");
        homePageObjects.clickChooseShopModule();
        chooseShopModule.selectShopByText("ashok shops");
        try {
            assertVariable = PropertyReader.getValueOfKey(PropertyReader.Keys.SHOP_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Shop Name cannot be read from Properties");
        }
        Assert.assertEquals(homePageObjects.getCurrentShopName(),assertVariable);
    }

    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){
        System.out.println("RedX After Suite");
        quitBaseDriver();
    }
}
