package com.redx.tests;

import coreUtils.*;
import io.appium.java_client.android.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import utils.*;
import java.util.*;

public class CreateParcel extends RedXBaseClass
{
    private AndroidDriver<WebElement> androidDriver;
    private HomePageObjects homePageObjects;
    private AddParcelPageObjects addParcelPageObjects;
    private SettingsPageObjects settingsPageObjects;
    private Authentication authentication;
    private ChangeLanguage changeLanguage;

    public void pageInitializer()
    {
        homePageObjects = new HomePageObjects();
        addParcelPageObjects = new AddParcelPageObjects();
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
    public void beforeCreateParcelClass() throws Exception
    {
        System.out.println("Before Create Parcel Class");
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
       changeLanguage.beforeChangeLanguageClass();
        changeLanguage.changeToEnglishLanguage();
    }

    @Test(  groups = {CoreConstants.GROUP_SMOKE, CoreConstants.GROUP_REGRESSION},
            description = "Create New Parcel",
            dependsOnGroups = {"Authentication.verifyAuthenticationWithValidCredentials"})
    public void createNewParcel()
    {
        System.out.println("Creating New Parcel");
        homePageObjects.clickDeliverYourParcelModule();
        Assert.assertEquals(addParcelPageObjects.getPageTitle(),"Add parcel");
        addParcelPageObjects.addParcel();
        Assert.assertEquals(homePageObjects.getToastMessage(),"1 parcels added");
    }

    @Test(  groups = {CoreConstants.GROUP_SANITY},
            priority = 3,
            description = "Verification of mandatory filed popUp on create parcel page")
    public void verifyMandatoryFieldCautionMessagePopup()
    {System.out.println("verification of mandatory field caution message popUp was called");
    homePageObjects.clickDeliverYourParcelModule();
    addParcelPageObjects.clickConfirmButton();
        List<String> cautionMessages = new ArrayList<>();
        cautionMessages.add("Name is required");
        cautionMessages.add("Phone is required");
        cautionMessages.add("Cash amount is required");
        cautionMessages.add("Selling price is required");
        cautionMessages.add("Address is required");
        Assert.assertEquals(cautionMessages,addParcelPageObjects.createParcelCautionMessages());
    }

    @AfterClass(alwaysRun = true)
    public void afterCreateParcelClass()
    {
        System.out.println("After Create Parcel Class");
    }

    @AfterSuite(alwaysRun = true)
    public void redXAndroidAfterSuite(){

        System.out.println("redXAndroidAfterSuite Is Called");
        quitBaseDriver();

    }



}
