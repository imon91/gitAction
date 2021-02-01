package com.redx.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;
import java.util.*;


public class ShopName extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private HomePageObjects.ChooseShopModule chooseShopModule;
    private Random random;
    private SettingsPageObjects settingsPageObjects;
    private SettingsPageObjects.OtherSettings otherSettings;
    private Authentication authentication;
    private ChangeLanguage changeLanguage;

        public void pageInitializer()
        {
            homePageObjects = new HomePageObjects();
            chooseShopModule = homePageObjects.new ChooseShopModule();
            random = new Random();
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
        public void shopNameBeforeClass() throws Exception
        {
            System.out.println("Before Shop Name Class");
            androidDriver = getBaseDriver();
            pageInitializer();
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
                description = "Verify Shop Name",
                dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
        public void verifyShopName()
        {
            String assertVariable = null;
            System.out.println("Verifying Shop Name");
            homePageObjects.clickChooseShopModule();
            chooseShopModule.selectShopByText("SHOPUP_TEST");
            try {
                assertVariable = PropertyReader.getValueOfKey(PropertyReader.Keys.SHOP_NAME);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Shop Name cannot be read from Properties");
            }
            Assert.assertEquals(homePageObjects.getCurrentShopName(),assertVariable);
        }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            description = "Verify ShopList BackButton",
            priority = 2)
    public void verifyShopListBackButton()
    {
        String assertVariable = null;
        System.out.println("Verifying Shop Name");
        homePageObjects.clickChooseShopModule();
        System.out.println("the current activity :"+androidDriver.currentActivity());
        chooseShopModule.clickOnBackButton();
    }


        @AfterClass(alwaysRun = true)
        public void afterChangeLanguageClass()
        {
            System.out.println("After Shop Name Class");
        }

    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){

        System.out.println("redXAndroidAfterSuite Is Called");
        quitBaseDriver();

    }

}
